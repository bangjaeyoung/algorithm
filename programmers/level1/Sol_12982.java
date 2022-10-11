package programmers.level1;

import java.util.Arrays;

// 1. 인자로 받은 배열 d를 오름차순으로 정렬
// 2. 배열을 순회하면서, 요소가 예산보다 클 경우, 반복문 탈출
// 3. 요소가 예산보다 작거나 같을 경우, 예산에서 요소를 빼면서 순회
// 4. 최종 가능 부서 개수(count)를 반환
public class Sol_12982 {
    public int solution(int[] d, int budget) {

        Arrays.sort(d);

        int count = 0;

        for (int a : d) {
            if (a > budget) break;

            count++;
            budget -= a;
        }
        return count;
    }
}
