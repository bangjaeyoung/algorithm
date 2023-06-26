package 프로그래머스.lv0;

import java.util.Arrays;

public class Sol_120817 {
    public double solution(int[] numbers) {

        return Arrays.stream(numbers).average().orElse(0.0);
    }
}
