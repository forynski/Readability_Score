package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] sentences = new Scanner(System.in).nextLine().split("[.!?]");
        int linesCounter = sentences.length;
        int words = 0;

        for (String sentence : sentences) {
            words += sentence.split("\\s+").length;
        }
        System.out.println(words/linesCounter <= 10 ? "EASY" : "HARD");
    }
}
