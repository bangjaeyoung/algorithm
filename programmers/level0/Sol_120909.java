package programmers.level0;

public class Sol_120909 {
    public int solution(int n) {

        return n % Math.sqrt(n) == 0 ? 1 : 2;
    }
}
