package 프로그래머스.lv0;

import java.util.ArrayList;
import java.util.List;

public class Sol_120852 {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                answer.add(i);
                n /= i;
            }
        }
        if (n != 1) answer.add(n);

        return answer.stream().distinct().mapToInt(i -> i).toArray();
    }
}
