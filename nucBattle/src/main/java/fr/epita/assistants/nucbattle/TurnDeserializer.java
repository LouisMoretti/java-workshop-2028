package fr.epita.assistants.nucbattle;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class TurnDeserializer extends JsonDeserializer<Turn> {
    Map<String, Nuc> NUCs;

    public TurnDeserializer(Map<String, Nuc> NUCs) {
        this.NUCs = NUCs;
    }

    @Override
    public Turn deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException,
            JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        String playerLogin = node.get("player_login").asText();
        String targetLogin = node.get("target_login").asText();

        ObjectMapper mapper = new ObjectMapper();
        Packet packet = mapper.convertValue(jsonParser, new TypeReference<Packet>() {});

        return new Turn(NUCs.get(playerLogin), playerLogin, NUCs.get(targetLogin), targetLogin, packet);
    }
}
