package programmers.level0;

// 인자로 받은 자연수 n 이하의 모든 짝수들의 합을 반환하라.
// 1. for문을 통해, i에 2씩 더하면서, n까지 짝수의 합을 구함
// 2. 짝수의 합을 반환
class Sol_120831 {
    public int solution(int n) {

        int sum = 0;

        // 1. for문을 통해, i에 2씩 더하면서, n까지 짝수의 합을 구함
        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }
        // 2. 짝수의 합을 반환
        return sum;
    }
}
