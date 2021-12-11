package baseball;

import utils.Game;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        game.start();

        // 재시작 여부
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String flag = scanner.nextLine();
            if (flag.equals("1")) {
                game.start();
            } else if (flag.equals("2")) {
                break;
            } else {
                System.out.println("잘못된 숫자를 입력하였습니다.");
            }
        }
    }
}
