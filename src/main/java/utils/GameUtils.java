package utils;

import java.util.Scanner;

public class GameUtils {
    private static boolean isEnd = false;
    public static void startGame(Scanner scanner) {
        String answer = makeAnswer();
        while (isEnd) {
            progressTurn(scanner);
        }
    }

    private static String makeAnswer() {
        Integer intAnswer = 100*RandomUtils.nextInt(1,9) + 10*RandomUtils.nextInt(1,9) + RandomUtils.nextInt(1,9);
        return intAnswer.toString();
    }

    private static void isValidInput(String input) {
        if (input.length()>3 || input.contains("0")) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void progressTurn(Scanner scanner) {
        System.out.printf("숫자를 입력해주세요 : ");
        String submitNumber = scanner.nextLine();
        isValidInput(submitNumber);
    }
}
