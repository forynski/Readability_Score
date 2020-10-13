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
//        int words = text.split("\\w+").length ;
//        int words = text.split("\\w+").length ;
        int words = text.replaceAll("[0-9]", "").split("\\w+").length ;

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

        // calculate score
        double score = 4.71 * ((double) characters / (double) words)
                + 0.5 * ((double) words / (double) sentences) - 21.43;
        System.out.printf("The score is: %.2f", score);
        System.out.println();
        int scoreRounded = (int) Math.ceil(score);

        switch (scoreRounded) {
            case 1:
                System.out.println("This text should be understood by 5-6 year olds.");
                break;
            case 2:
                System.out.println("This text should be understood by 6-7 year olds.");
                break;
            case 3:
                System.out.println("This text should be understood by 7-9 year olds.");
                break;
            case 4:
                System.out.println("This text should be understood by 9-10 year olds.");
                break;
            case 5:
                System.out.println("This text should be understood by 10-11 year olds.");
                break;
            case 6:
                System.out.println("This text should be understood by 11-12 year olds.");
                break;
            case 7:
                System.out.println("This text should be understood by 12-13 year olds.");
                break;
            case 8:
                System.out.println("This text should be understood by 13-14 year olds.");
                break;
            case 9:
                System.out.println("This text should be understood by 14-15 year olds.");
                break;
            case 10:
                System.out.println("This text should be understood by 15-16 year olds.");
                break;
            case 11:
                System.out.println("This text should be understood by 16-17 year olds.");
                break;
            case 12:
                System.out.println("This text should be understood by 17-18 year olds.");
                break;
            case 13:
                System.out.println("This text should be understood by 18-24 year olds.");
                break;
            case 14:
                System.out.println("This text should be understood by 24+ year olds.");
                break;
        }


    }

    public static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
