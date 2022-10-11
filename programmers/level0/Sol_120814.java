package programmers.level0;

public class Sol_120814 {
    public int solution(int n) {

        return n % 7 == 0 ? (n / 7) : (n / 7 + 1);
    }
}
