package 프로그래머스.lv0;

public class Sol_120848 {
    public int solution(int n) {

        int answer = 0;

        for (int i = 0; i <= 11; i++) {
            if (factorial(i) > n) {
                answer = i - 1;
                break;
            }
        }
        return answer;
    }

    public int factorial(int num) {
        if (num <= 1) return 1;
        return num * factorial(num - 1);
    }
}
