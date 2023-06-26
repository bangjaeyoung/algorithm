package 프로그래머스.lv0;

import java.util.Arrays;

public class Sol_120583 {
    public int solution(int[] array, int n) {

        return (int) Arrays.stream(array).filter(e -> e == n).count();
    }
}
