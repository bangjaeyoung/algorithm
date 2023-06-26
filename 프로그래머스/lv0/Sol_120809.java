package 프로그래머스.lv0;

import java.util.Arrays;

public class Sol_120809 {
    public int[] solution(int[] numbers) {

        return Arrays.stream(numbers).map(e -> e * 2).toArray();
    }
}
