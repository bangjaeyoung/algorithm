package programmers.level1;

// 1. num이 1이 될 때까지, 반복문 돌리기
// 2-1. num이 짝수라면 2로 나누기
// 2-2. num이 홀수라면 3을 곱하고 1을 더하기
// 3. 반복문을 한 번 돌 때마다, count를 1 증가
// 4. count가 500이 되는 순간 -1 반환
// 5. 결과로 count를 반환

public class Sol_12943 {

    public int solution(long num) {

        // 예외 조건
        if (num == 1) {
            return 0;
        }

        // 횟수를 카운트하는 count 변수 초기화
        int count = 0;

        // num이 1이 될 때까지, 반복
        while (num > 1) {

            // 500번이 되도록 1이 되지 않으면, -1 반환
            if (count == 500) {
                return -1;
            }

            // 짝수일 경우,
            if (num % 2 == 0) {
                num /= 2;
            }
            // 홀수일 경우,
            else {
                num = num * 3 + 1;
            }

            count++;
        }
        return count;
    }
}