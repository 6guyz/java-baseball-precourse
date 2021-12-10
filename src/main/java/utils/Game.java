package utils;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String answer;
    private boolean end = false;

    public Game() {
        this.makeAnswer();
    }

    private void makeAnswer() {
        List<String> answerNumberList = new ArrayList<String>();
        while (answerNumberList.size() < 3) {
            String nextNumber = String.valueOf(RandomUtils.nextInt(1,9));
            if (answerNumberList.contains(nextNumber)) {
                continue;
            }
            answerNumberList.add(nextNumber);
        }
        this.answer = String.join("", answerNumberList);
    }

    public boolean checkAnswer(String input) {
        if (this.answer.equals(input)) {
            return true;
        }
        return false;
    }

    public int countStrike(String input) {
        int strike = 0;
        for (int i=0; i<3; i++) {
            if (input.charAt(i) == this.answer.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(String input) {
        int ball = 0;
        for (int i=0; i<3; i++) {
            if (this.answer.contains(String.valueOf(input.charAt(i))) && this.answer.indexOf(input.charAt(i))!=i) {
                ball++;
            }
        }
        return ball;
    }

    public boolean isEnd() {
        return this.end;
    }

    public void end() {
        this.end = true;
    }

    public void printBallAndStrike(int ball, int strike) {
        if (ball > 0) {
            System.out.printf(ball+"볼 ");
        }
        if (strike > 0) {
            System.out.printf(strike+"스트라이크");
        }
        System.out.println();
    }
}
