package utils;

import java.util.HashMap;
import java.util.Map;

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
        if (targetNumber.equals(userNumber)) return true;

        String[] targetNumberArray = targetNumber.split("");
        Map<String, Integer> map = createTargetNumberMap(targetNumberArray);
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < targetNumber.length(); i++ ) {
            String targetNum = Character.toString(targetNumber.charAt(i));
            String userNum = Character.toString(userNumber.charAt(i));

            if (targetNum.equals(userNum)) {
                strikes++;
                map.put(targetNum, map.get(targetNum) - 1);
            } else {
                if (map.containsKey(userNum) && map.get(userNum) != 0) {
                    map.put(userNum, map.get(userNum) - 1);
                    balls++;
                }
            }
        }

        if (balls != 0 && strikes != 0) {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
        } else if (balls != 0 && strikes == 0) {
            System.out.printf("%d볼\n", balls);
        } else if (balls == 0 && strikes != 0) {
            System.out.printf("%d스트라이크\n", strikes);
        }
        return false;
    }
    private Map<String, Integer> createTargetNumberMap(String[] targetNumberArray) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String num : targetNumberArray) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map;
    }
}
