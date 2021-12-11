package utils;

import java.util.ArrayList;
import java.util.List;

public class GameUtils {

    // 유효성 검사(숫자 && 3자리 숫자)
    public String getValidDigit(String userInput) {
        boolean isDigit = userInput.chars().allMatch(Character::isDigit);

        if (!isDigit || !is3Digit(Integer.parseInt(userInput))) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }
    private boolean is3Digit(int number) {
        boolean flag = false;

        if (100 <= number && number < 1000) {
            flag = true;
        }
        return flag;
    }

    // targetNumber and userNumber 비교
    public boolean compareTargetAndUserNumber(String targetNumber, String userNumber) {
        if (targetNumber == userNumber) return true;

        List<String> stack = new ArrayList<String>();
        for (int i = 0; i < targetNumber.length(); i++ ) {

        }



        return true;
    }
}
