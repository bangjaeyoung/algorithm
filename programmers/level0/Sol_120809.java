package programmers.level0;

import java.util.Arrays;

public class Sol_120809 {
    public int[] solution(int[] numbers) {

        return Arrays.stream(numbers).map(e -> e * 2).toArray();
    }
}
