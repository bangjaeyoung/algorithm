package programmers.level0;

import java.util.Arrays;

public class Sol_120585 {
    public int solution(int[] array, int height) {

        return (int) Arrays.stream(array).filter(e -> e > height).count();
    }
}
