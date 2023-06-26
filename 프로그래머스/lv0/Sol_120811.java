package 프로그래머스.lv0;

import java.util.Arrays;

public class Sol_120811 {
    public int solution(int[] array) {

        Arrays.sort(array);

        return array[array.length / 2];
    }
}
