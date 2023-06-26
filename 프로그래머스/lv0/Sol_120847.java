package 프로그래머스.lv0;

import java.util.Arrays;

public class Sol_120847 {
    public int solution(int[] numbers) {

        // 배열 numbers를 오름차순으로 정렬
        Arrays.sort(numbers);

        // 배열의 마지막 요소와 (마지막 - 1)번째 요소를 곱하면 최댓값
        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }
}
