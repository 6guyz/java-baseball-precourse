package utils;

import java.util.Scanner;

public class GameUtils {
    private static boolean isEnd = false;
    public static void startGame(Scanner scanner) {
        String answer = makeAnswer();
        while ( !isEnd ) {
            progressTurn(scanner, answer);
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

    private static void progressTurn(Scanner scanner, String answer) {
        System.out.printf("숫자를 입력해주세요 : ");
        String submitNumber = scanner.nextLine();
        isValidInput(submitNumber);
        if (isAnswer(submitNumber, answer)) {
            isEnd = true;
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static boolean isAnswer(String submitNumber, String answer) {
        if (answer.equals(submitNumber)) {
            return true;
        }
        return false;
    }
}
