package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattleManager {
    String json;

    public BattleManager(String path) {
        try {
            json = Files.readString(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void computeBattle(String reportPath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readTree(json);
        Map<String, Nuc> NUCs = mapper.convertValue(node.get("NUCs"), new TypeReference<Map<String, Nuc>>() {
        });

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Turn.class, new TurnDeserializer(NUCs));
        mapper.registerModule(module);

        List<Turn> turns = mapper.convertValue(node.get("battle").get("turns"), new TypeReference<List<Turn>>() {
        });

        Map<String, Float> outcome = new HashMap<>();
        for (String name : NUCs.keySet()) {
            Float hp = NUCs.get(name).getHp();
            if (hp > 100.)
                hp = 100F;
            outcome.put(name, hp);
        }

        Report report = null;

        // Check if someone already win
        int alive = 0;
        String last_player = null;
        for (String player: outcome.keySet()){
            if (outcome.get(player) > 0) {
                alive++;
                last_player = player;
            }
        }

        if (alive == 1) {
            report = new Report(ReportType.WINNER, last_player, outcome);
        } else {
            for (Turn turn : turns) {
                String playerLogin = turn.getPlayerLogin();
                String targetLogin = turn.getTargetLogin();

                if (!outcome.containsKey(playerLogin) || !outcome.containsKey(targetLogin)) {
                    report = new Report(ReportType.ERROR, null, null);
                    break;
                }

                Packet packet = turn.getPacket();

                Nuc playerNuc = turn.getPlayerNuc();
                Nuc targetNuc = turn.getTargetNuc();

                // Check used program
                List<String> usedPrograms = packet.getUsedPrograms();
                if (!playerNuc.getInstalledPrograms().containsAll(usedPrograms)) {
                    report = new Report(ReportType.CHEATER, playerLogin, null);
                    break;
                }

                Float newHp = outcome.get(targetLogin) - packet.getDamage();
                if (newHp < 0F) newHp = 0F;
                if (newHp > 100F) newHp = 100F;

                outcome.put(targetLogin, newHp);

                alive = 0;
                last_player = null;
                for (String player: outcome.keySet()){
                    if (outcome.get(player) > 0) {
                        alive++;
                        last_player = player;
                    }
                }

                if (alive == 1) {
                    report = new Report(ReportType.WINNER, last_player, outcome);
                    break;
                }
            }
        }

        if (report == null)
            report = new Report(ReportType.UNFINISHED, null, outcome);

//        mapper = new ObjectMapper();
        mapper.writeValue(new File(reportPath), report);
    }
}
