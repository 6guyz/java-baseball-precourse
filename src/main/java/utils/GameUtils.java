package utils;

public class GameUtils {
    public static void startGame() {
    }

    public static String makeAnswer() {
        Integer intAnswer = 100*RandomUtils.nextInt(1,9) + 10*RandomUtils.nextInt(1,9) + RandomUtils.nextInt(1,9);
        return intAnswer.toString();
    }
}
