package 프로그래머스.lv0;

import java.util.Arrays;

public class Sol_120585 {
    public int solution(int[] array, int height) {

        return (int) Arrays.stream(array).filter(e -> e > height).count();
    }
}
