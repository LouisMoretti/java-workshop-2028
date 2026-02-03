package fr.epita.assistants.embedfiles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class DisplayEmbedFile {
    private final String filename;

    public DisplayEmbedFile(String filename) {
        this.filename = filename;
    }

    public Optional<String> display() {
        InputStream resource = getClass().getClassLoader().getResourceAsStream(filename);
        if (resource == null)
            return Optional.empty();
        StringBuilder retBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                retBuilder.append((char) c);
            }
        } catch (IOException e) {
            return Optional.empty();
        }
        return Optional.of(retBuilder.toString());
    }
}
