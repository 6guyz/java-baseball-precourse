package utils;

import java.util.Scanner;

public class GameUtils {
    public static void startGame(Scanner scanner) {
        String answer = makeAnswer();
        System.out.printf("숫자를 입력해주세요 : ");
        while (true) {
            scanner.nextLine();
        }
    }

    private static String makeAnswer() {
        Integer intAnswer = 100*RandomUtils.nextInt(1,9) + 10*RandomUtils.nextInt(1,9) + RandomUtils.nextInt(1,9);
        return intAnswer.toString();
    }
}
