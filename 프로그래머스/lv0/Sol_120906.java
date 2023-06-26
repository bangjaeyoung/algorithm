package 프로그래머스.lv0;

public class Sol_120906 {
    public int solution(int n) {

        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
