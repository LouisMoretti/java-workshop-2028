package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

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

    public void computeBattle(String reportPath) throws JsonProcessingException {
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
        for (String name: NUCs.keySet()) {
            Float hp = NUCs.get(name).getHp();
            if (hp > 100.)
                hp = 100F;
            outcome.put(name, hp);
        }

        for (Turn turn : turns) {
            turn.getPlayerNuc();
        }

    }
}
