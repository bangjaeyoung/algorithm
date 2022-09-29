package programmers.level1;

import java.util.Arrays;

// 배열에서 제일 작은 요소를 제거한다.
// 예외) 배열의 요소가 10 단 하나라면, -1을 가진 배열을 반환한다.
// 1. 배열에서 제일 작은 요소를 찾는다.
// 2. 제일 작은 요소를 제거한 배열을 반환한다.

public class Sol_12935 {

    public int[] solution(int[] arr) {

        // 예외) 배열의 요소가 10 단 하나라면, -1을 가진 배열을 반환한다.
        if (arr.length == 1 && arr[0] == 10) {
            return new int[]{-1};
        }

        // 1. 배열에서 제일 작은 요소를 찾는다.
        int min = Arrays.stream(arr).min().getAsInt();

        // 2. 제일 작은 요소가 없는 배열을 반환한다.
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
}
