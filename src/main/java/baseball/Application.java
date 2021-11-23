package baseball;

import utils.GameUtils;
import utils.RandomUtils;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String answer = GameUtils.makeAnswer();
        System.out.println(answer);
        GameUtils.startGame();
    }
}
