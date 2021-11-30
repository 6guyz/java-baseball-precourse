package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private ArrayList<Integer> answer;
    private boolean isEnd = false;

    public Game() {
        this.makeAnswer();
    }

    private void makeAnswer() {
        ArrayList<Integer> answerNumberList = new ArrayList<Integer>();
        while (answerNumberList.size() < 3) {
            int nextNumber = RandomUtils.nextInt(1,9);
            if (answerNumberList.contains(nextNumber)) {
                continue;
            }
            answerNumberList.add(nextNumber);
        }
        this.answer = answerNumberList;
    }

    private boolean checkAnswer() {

    }

    private int countStrike() {

    }

    private int countBall() {

    }

}
