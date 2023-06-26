package 프로그래머스.lv0;

import java.util.Arrays;

public class Sol_120890 {
    public int solution(int[] array, int n) {

        Arrays.sort(array);

        int difference = Math.abs(n - array[0]);
        int answer = array[0];

        for (int i = 1; i < array.length; i++) {
            if (Math.abs(n - array[i]) < difference) {
                difference = Math.abs(n - array[i]);
                answer = array[i];
            }
        }
        return answer;
    }
}
