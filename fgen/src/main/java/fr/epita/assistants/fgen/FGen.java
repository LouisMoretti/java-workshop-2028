package fr.epita.assistants.fgen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class FGen {
    Path workingDirectory;
    Path currentDirectory;

    public FGen(final String workingDirectoryPath) {
        this.workingDirectory = Paths.get(workingDirectoryPath).toAbsolutePath();
        this.currentDirectory = this.workingDirectory;
    }

    private void createDirAndFiles(String arg) throws IOException {
        Path newPath = currentDirectory.resolve(arg);

        if (Files.exists(newPath)) return;

        if (arg.endsWith("/")) {
            Files.createDirectories(newPath);
        } else {
            if (newPath.getParent() != null && !Files.exists(newPath.getParent()))
                Files.createDirectories(newPath.getParent());
            Files.createFile(newPath);
        }
    }

    private void changeCurPath(String arg) {
        Path newPath = currentDirectory.resolve(arg);

        if (!Files.exists(newPath) || !Files.isDirectory(newPath))
            throw new RuntimeException(); // TODO: ecrire qqc

        this.currentDirectory = newPath;
    }

    private void deleteDirAndFiles(String arg) throws IOException {
        Path newPath = currentDirectory.resolve(arg);

        if (!Files.exists(newPath)) return;

        if (Files.isDirectory(newPath)) {
            try (Stream<Path> walk = Files.walk(newPath)) {
                walk.sorted(Comparator.reverseOrder())
                        .forEach(path -> {
                            try {
                                Files.delete(path);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
            }
        } else {
            Files.delete(newPath);
        }
    }

    private void executeLine(String line) throws IOException {
        if (line.length() < 3)
            throw new RuntimeException(); // TODO: ecrire qqc

        char opCode = line.charAt(0);

        if (opCode == '+') {
            createDirAndFiles(line.substring(2));
        } else if (opCode == '>') {
            changeCurPath(line.substring(2));
        } else if (opCode == '-') {
            deleteDirAndFiles(line.substring(2));
        } else {
            throw new RuntimeException();  // TODO: ecrire qqc
        }
    }

    public void run(final String scriptPath) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(scriptPath);

        if (inputStream == null)
            throw new RuntimeException(); // TODO: ecrire qqc

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                executeLine(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
