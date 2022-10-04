package programmers.level0;

import java.util.Arrays;

public class Sol_120583 {
    public int solution(int[] array, int n) {

        return (int) Arrays.stream(array).filter(e -> e == n).count();
    }
}
