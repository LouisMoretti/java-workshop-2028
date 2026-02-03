package fr.epita.assistants.embedfiles;

import java.util.Optional;

public class DisplayEmbedFile {
    private final String filename;

    public DisplayEmbedFile(String filename) {
        this.filename = filename;
    }

    public Optional<String> display() {
        String ret = String.valueOf(getClass().getClassLoader().getResource(filename));
        return Optional.ofNullable(ret);
    }
}
