package readability;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("[\\w-]+");
        Matcher matcher = pattern.matcher(text);
        int counter = 0;
        while (matcher.find())
            counter++;

        char char1 = '.';
        char char2 = '!';
        char char3 = '?';

        int symbolCounter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == char1 || text.charAt(i) == char2 || text.charAt(i) == char3) {
                symbolCounter++;
            }
        }

        double doubleCounter = counter;
        double doubleSymbolCounter = symbolCounter;
        double finalCounter = doubleCounter / doubleSymbolCounter;

        if (finalCounter > 10) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");

        }
    }
}

