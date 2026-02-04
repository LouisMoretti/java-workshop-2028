package fr.epita.assistants.mykitten;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyKitten {

    public Stream<String> streamContent;

    /**
     * Initializer.
     *
     * @param srcPath Source file path.
     */
    public MyKitten(String srcPath) {
        try {
            streamContent = Files.lines(Paths.get(srcPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Use the streamContent to replace `wordToReplace` with "miaou".
     * Do not forget to add the line number beforehand for each line.
     * Store the new result directly in the streamContent field.
     *
     * @param wordToReplace The word to replace
     */
    public void replaceByMiaou(String wordToReplace) {
        AtomicInteger n = new AtomicInteger(0);
        streamContent.map(line ->
        {
            return String.format("%d %s", n.incrementAndGet(), line.replaceAll(wordToReplace, "miaou"));
        });
    }

    /**
     * Use the streamContent to write the content into the destination file.
     *
     * @param destPath Destination file path.
     */
    public void toFile(String destPath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(destPath))) {
            streamContent.forEach(str -> {
                try {
                    writer.write(str);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
                writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates an instance of MyKitten and calls the above methods to do it
     * straightforwardly.
     *
     * @param srcPath       Source file path
     * @param destPath      Destination file path
     * @param wordToReplace Word to replace
     */
    public static void miaou(String srcPath, String destPath,
                             String wordToReplace) {
        MyKitten chat = new MyKitten(srcPath);
        chat.replaceByMiaou(wordToReplace);
        chat.toFile(destPath);
    }
}
