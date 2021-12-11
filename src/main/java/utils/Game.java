package utils;

import java.util.Scanner;

public class Game {
    final Scanner scanner = new Scanner(System.in);

    private GameUtils gameUtils;

    public Game() {
        gameUtils = new GameUtils();
    }

    public void start() {
        gameUtils.create3digits();
    }
}
