package programmers.level2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Sol_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        Map<Integer, Integer> possibleAnswer = new LinkedHashMap<>();
        int sum = brown + yellow;

        for (int i = 1; i <= sum; i++) {
            if (sum % i == 0) {
                possibleAnswer.put(i, sum / i);
            }
        }

        for (Integer key : possibleAnswer.keySet()) {
            int value = possibleAnswer.get(key);

            if (key >= value && (key - 2) * (value - 2) == yellow) {
                answer[0] = key;
                answer[1] = value;
                break;
            }
        }

        return answer;
    }
}
