package programmers.level1;

import java.util.Arrays;

// 배열 arr의 요소 중에 divisor로 나누어떨어지는 수들만 존재하는 배열을 반환해라.
// 1. 결과를 담을 새로운 배열을 생성
// 2. 반복문을 순회하면서, divisor와 나누어떨어지는 수들로만 이루어진 배열로 변환
// 3. 배열 오름차순으로 정렬
// 4. 만약, 나누어떨어지는 수가 하나도 없으면, 배열에 -1을 넣은 배열을 반환

public class Sol_12910 {

    public int[] solution(int[] arr, int divisor) {

        int[] answer = Arrays.stream(arr).filter(e -> e % divisor == 0).sorted().toArray();

        if (Arrays.stream(answer).count() == 0) {
            return new int[]{-1};
        }
        return answer;
    }
}
