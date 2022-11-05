package programmers.level0;

import java.util.Arrays;

public class Sol_120812 {
    public int solution(int[] array) {
        Arrays.sort(array);

        // 편하게 구분하기 위해 제일 큰 수보다 1 더 큰 길이의 배열을 생성(0번째 인덱스는 더미 요소)
        int[] numCount = new int[array[array.length - 1] + 1];
        for (int arr : array) {
            numCount[arr]++;
        }

        int maxCount = -1;
        int answer = -1;

        for (int i = 0; i < numCount.length; i++) {
            if (numCount[i] == maxCount) answer = -1;    // 최빈값 여러 개
            if (numCount[i] > maxCount) {                // 최빈값 구하기
                maxCount = numCount[i];
                answer = i;
            }
        }
        return answer;
    }
}
