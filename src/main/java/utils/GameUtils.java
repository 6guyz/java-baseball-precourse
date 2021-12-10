package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameUtils {
    public static void startGame(Scanner scanner) {
        Game game = new Game();
        while ( !game.isEnd() ) {
            progressTurn(scanner, game);
        }
    }

    private static void progressTurn(Scanner scanner, Game game) {
        System.out.printf("숫자를 입력해주세요 : ");
        String submitNumber = scanner.nextLine();
        isValidInput(submitNumber);
        System.out.println(submitNumber);
        if (game.checkAnswer(submitNumber)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            game.end();
            return;
        }
        int strike = game.countStrike(submitNumber);
        int ball = game.countBall(submitNumber);
        if (strike > 0 || ball > 0) {
            game.printBallAndStrike(ball, strike);
        } else {
            System.out.println("낫싱");
        }

    }

    private static void isValidInput(String input) {
        if (input.length()>3 || input.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkRestart(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restartInput = scanner.nextInt();
        if (restartInput==1) {
            return true;
        }
        return false;
    }
}
