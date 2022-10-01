package programmers.level1;

// 0부터 9까지의 수 중에 인자로 받은 numbers 배열에 없는 수들을 더한 값을 반환하라.
// 1. 0부터 9까지의 합을 구함
// 2. numbers 배열의 모든 수의 합을 구함
// 3. 1번 - 2번의 값을 반환
public class Sol_86051 {
    public int solution(int[] numbers) {

        int total = 0;
        int sum = 0;

        // 1. 0부터 9까지의 합을 구함
        for (int i = 0; i < 10; i++) {
            total += i;
        }
        // 2. numbers 배열의 모든 수의 합을 구함
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        // 3. 1번 - 2번의 값을 반환
        return total - sum;
    }
}
