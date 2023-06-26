package programmers.level1;

// left부터 right까지의 자연수 중에서, 약수의 개수가 짝수인 수들은 더하고, 홀수인 수들은 빼라.
// 1. for문을 통해, left부터 right까지 1씩 더하며 모든 수들을 비교
// 2. 수가 제곱수이면 약수의 개수가 홀수, 아닐 경우 짝수
public class Sol_77884 {
    public int solution(int left, int right) {

        // 수들을 더하고 뺀 최종 연산 결과 변수 선언
        int sum = 0;

        // 1. for문을 통해, left부터 right까지 1씩 더하며 모든 수들을 비교
        for (int i = left; i <= right; i++) {

            // 2. 수가 제곱수이면 약수의 개수가 홀수이므로, 수를 빼줌
            if (i % Math.sqrt(i) == 0) {
                sum -= i;
            }
            // 아닐 경우 짝수이므로, 수를 더해줌
            else sum += i;
        }
        return sum;
    }
}
