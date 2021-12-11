package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 게임 전체를 마무리할 boolean 변수 game
        boolean game = true;

        while (game) {
            // 실행함과 동시에 정답을 생성합니다.
            List<Integer> answer = makeAnswer();
            System.out.println("answer = " + answer);

            // 또다른 while 문을 빠져나올 변수 flag 변수를 생성
            boolean flag = true;
            while (flag) {
                String mention = loopCycle(answer);
                boolean finish = isFinish(mention);
                flag = !finish;
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String retry = Console.readLine();
            if (retry.equals("2")) {
                game = false;
            }
        }
    }

    /**
     * 게임내에서 반복되는 로직들을 묶어놓은 메소드
     * 1. 숫자를 입력받고  inputRead()
     * 2. 정답을 확인하고  checkBallAndStrike()
     * 3. 안내 멘트를 제공 mention()
     * @param answer 정답으로 입력된 숫자들을 List로
     * @return 안내멘트  "1볼 1스트라이크"
     */
    private static String loopCycle(List<Integer> answer) {
        // 사용자의 입력을 받습니다.
        List<Integer> inputIntegers = inputRead();

        // Strike 와 Ball 을 계산합니다. Ball, Strike 순서로 return
        Integer[] ballAndStrike = checkBallAndStrike(answer, inputIntegers);

        // 관련 안내멘트 출력
        String mention = mention(ballAndStrike);
        System.out.println(mention);
        return mention;
    }

    private static boolean isFinish(String mention) {
        return mention.equals("3스트라이크 ");
    }


    private static String mention(Integer[] ballAndStrike) {
        String result = "";

        if (ballAndStrike[0] != 0) result += ballAndStrike[0] + "볼 ";
        if (ballAndStrike[1] != 0) result += ballAndStrike[1] + "스트라이크 ";

        if (result.equals("")) result += "낫싱";

        return result;
    }


    private static Integer[] checkBallAndStrike(List<Integer> answer, List<Integer> inputIntegers) {
        Integer[] arr = new Integer[10];

        // 빈 arr 에 값을 기준으로 index 를 지정함, 없으면 null
        for (int i = 0; i < answer.size(); i++) {
            arr[answer.get(i)] = i;
        }

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < inputIntegers.size(); i++) {
            Integer idx = arr[inputIntegers.get(i)];

            // 찾고자 하는 값이 존재하지 않는다면 ?
            if (idx == null) continue;

            // 존재하고, 같은 위치라면 strike, 다른 위치라면 ball += 1
            if (idx.equals(i)) strike += 1;
            else ball += 1;
        }

        // return 할 result 변수 만들어서 리턴
        Integer[] result = new Integer[2];
        result[0] = ball;
        result[1] = strike;

        return result;
    }

    public static List<Integer> makeAnswer() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public static List<Integer> inputRead() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        // 들어온 문자 검증
        isValid(input);

        // 검증이 완료됐다면, 각각의 숫자를 담아서 return
        int first = Integer.parseInt(input.substring(0, 1));
        int second = Integer.parseInt(input.substring(1, 2));
        int third = Integer.parseInt(input.substring(2, 3));

        ArrayList<Integer> inputs = new ArrayList<>();
        inputs.add(first);
        inputs.add(second);
        inputs.add(third);

        return inputs;
    }

    /**
     * 예외처리 메소드
     * 1. 길이가 3이 아니라면
     * 2. 입력값중 숫자가 아닌 값이 있다면
     * @param input 사용자의 입력값, validation 으로 이용할 변수
     */
    private static void isValid(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값이 3개여야합니다.");
        }
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력하지 마세요.");
        }
    }
}
