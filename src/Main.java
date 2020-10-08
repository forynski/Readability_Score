package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

//        if (text.length() > 100) {
//            System.out.println("HARD");
//        } else {
//            System.out.println("EASY");
//        }

        int counter = (text.split("(([a-zA-Z0-9]([-][_])*[a-zA-Z0-9])+)", -1).length
                + text.replaceAll("([[a-z][A-Z][0-9][\\W][-][_]]*)", "").length() - 1);

        if (counter > 10) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }

    }
}
