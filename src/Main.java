package readability;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        String text = readFile(file.toString());
        System.out.println(text);

        // words counter
        int words = text.split("\\w+").length ;
        System.out.println("Words: " + words);

        // sentences counter
        int sentences = text.split("[.!?]").length;
        System.out.println("Sentences: " + sentences);

        // characters counter
        String whitespacesRemover = text.replaceAll("\\s+","").toString();
        int characters = 0;
        for (int i = 0; i < whitespacesRemover.length(); i++) {
            characters++;
        }
        System.out.println("Characters: " + characters);
    }

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
