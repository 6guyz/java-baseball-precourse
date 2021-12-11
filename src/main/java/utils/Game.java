package utils;

import java.util.Scanner;

public class Game {
    final Scanner scanner = new Scanner(System.in);

    private TargetNumberCreator targetNumberCreator;
    private GameUtils gameUtils;

    public void start() {
        // get targetNumber
        String targetNumber = targetNumberCreator.getTargetNumber();

        // 게임 진행
        boolean isCorrect = progressGame(targetNumber);

        // 게임 종료
        if (isCorrect) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private boolean progressGame(String targetNumber) {
        boolean isCorrect;

        while (true) {
            String userInput = scanner.nextLine();
            boolean isSame;

            try {
                String userNumber = gameUtils.getValidDigit(userInput);  // 유효성 검사
                isSame = gameUtils.compareTargetAndUserNumber(targetNumber, userNumber);  // 값 비교
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                isCorrect = false;
                break;
            }

            if (isSame) {
                isCorrect = true;
                break;
            }

        }

        return isCorrect;
    }
}
