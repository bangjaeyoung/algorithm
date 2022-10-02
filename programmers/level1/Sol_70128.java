package programmers.level1;

import java.util.stream.IntStream;

// 인자로 받은 배열 a와 b의 내적을 구하라.
// 1. 둘 중 하나의 배열의 길이만큼 반복해서, 배열의 요소들을 서로 곱한 값을 모두 더한 값을 반환
public class Sol_70128 {
    public int solution(int[] a, int[] b) {

        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }
}
