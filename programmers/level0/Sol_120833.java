package programmers.level0;

import java.util.Arrays;

public class Sol_120833 {
    public int[] solution(int[] numbers, int num1, int num2) {

        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
