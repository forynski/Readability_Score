package readability;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private final static Map<Integer, String> ARI = new HashMap<Integer, String>() {{
        put(1, "5-6");
        put(2, "6-7");
        put(3, "7-9");
        put(4, "9-10");
        put(5, "10-11");
        put(6, "11-12");
        put(7, "12-13");
        put(8, "13-14");
        put(9, "14-15");
        put(10, "15-16");
        put(11, "16-17");
        put(12, "17-18");
        put(13, "18-24");
        put(14, "24+");
    }};


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));
            String text = scanner.nextLine();
            scanner.close();
            System.out.println("The text is:");
            System.out.println(text);
            String[] sentencesArray = text.split("[.!?]");
            int words = 0;
            int sentences = sentencesArray.length;
            int characters = text.endsWith(".") ? sentences : sentences - 1;
            int syllables = 0;
            int polysyllables = 0;
            for (String sentence : sentencesArray) {
                String[] wordsArray = sentence.trim().split("[\\s\\h]+");
                words += wordsArray.length;
                for (String word : wordsArray) {
                    characters += word.length();
                    int syllablesInWord = getSyllabes(word);
                    syllables += syllablesInWord;
                    if (syllablesInWord > 2) {
                        polysyllables++;
                    }
                }
            }
            System.out.println("Words: " + words);
            System.out.println("Sentences: " + sentences);
            System.out.println("Characters: " + characters);
            System.out.println("Syllables: " + syllables);
            System.out.println("Polysyllables: " + polysyllables);
            double score = calculateScore(sentences, words, characters, syllables, polysyllables);
            displayScore(score);

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static int getSyllabes(String word) {
        int syllabes = 0;
        boolean lastWasVowel = false;
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        loop:
        for (char letter : word.toCharArray()) {
            for (char vowel : vowels) {
                if (vowel == letter) {
                    if (!lastWasVowel) {
                        syllabes++;
                    }
                    lastWasVowel = true;
                    continue loop;
                }
            }
            lastWasVowel = false;
        }
        if (word.endsWith("e")) {
            syllabes--;
        }
        return Math.max(syllabes, 1);
    }

    public static double calculateScore(int sentences, int words, int characters, int syllables, int polysyllables) {
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL):");
        String scoreType = new Scanner(System.in).nextLine().toUpperCase();
        switch (scoreType) {
            case "ARI":
                return ARI(sentences, words, characters);
            case "FK":
                return FK(sentences, words, syllables);
            case "SMOG":
                return SMOG(sentences, polysyllables);
            case "CL":
                return CL(sentences, words, characters);
            default:
                return (ARI(sentences, words, characters) +
                        FK(sentences, words, syllables) +
                        SMOG(sentences, polysyllables) +
                        CL(sentences, words, characters)
                ) / 4;
        }
    }

    public static double ARI(int sentences, int words, int characters) {
        double score = 4.71 * characters / words + 0.5 * words / sentences - 21.43;
        displayScore("Automated Readability Index", score);
        return score;
    }

    public static double FK(int sentences, int words, int syllables) {
        double score = 0.39 * words / sentences + 11.8 * syllables / words - 15.59;
        displayScore("Flesch–Kincaid readability tests", score);
        return score;
    }

    public static double SMOG(int sentences, int polysyllables) {
        double score = 1.043 * Math.sqrt(polysyllables * 30 / (double) sentences) + 3.1291;
        displayScore("Simple Measure of Gobbledygook", score);
        return score;
    }

    public static double CL(int sentences, int words, int characters) {
        double score = 0.0588 * (characters / (double) words * 100) - 0.296 * (sentences / (double) words * 100) - 15.8;
        displayScore("Coleman–Liau index", score);
        return score;
    }

    private static void displayScore(String scoreType, double score) {
        double round = (int) Math.round(score * 100) / 100.0;
        int ceil = (int) Math.ceil(round);
        System.out.println(scoreType + ": " + round + " (about " + ARI.get(ceil) + " year olds).");
    }

    private static void displayScore(double score) {
        int ceil = (int) Math.ceil(score);
        System.out.println("The text should be understood in average by " + ARI.get(ceil) + "years olds.");
    }
}
