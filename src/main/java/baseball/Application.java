package baseball;

import utils.GameUtils;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        try {
            GameUtils.startGame(scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            if (GameUtils.checkRestart(scanner)) {
                try {
                    System.out.println("!!!!1");
                    GameUtils.startGame(scanner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }
}
