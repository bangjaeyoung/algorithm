package programmers.level2;

public class Sol_12924 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int tempI = i;

            while (true) {
                sum += tempI;
                tempI++;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) break;
            }
        }

        return answer;
    }
}
