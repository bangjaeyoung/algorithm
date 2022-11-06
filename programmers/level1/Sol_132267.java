package programmers.level1;

public class Sol_132267 {
    public int solution(int a, int b, int n) {
        int totalCoke = 0;
        int receiveCoke; // 한 턴마다 받는 콜라 빈 병 개수
        int remainCoke;  // 한 턴마다 남는 콜라 빈 병 개수

        while (n >= a) {
            receiveCoke = (n / a) * b;
            remainCoke = n % a;
            totalCoke += receiveCoke;
            n = receiveCoke + remainCoke;
        }
        return totalCoke;
    }
}
