package programmers.level0;

import java.util.Arrays;

public class Sol_120817 {
    public double solution(int[] numbers) {

        return Arrays.stream(numbers).average().orElse(0.0);
    }
}
