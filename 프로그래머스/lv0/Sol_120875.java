package 프로그래머스.lv0;

public class Sol_120875 {
    public int solution(int[][] dots) {
        double slopA = (double) (dots[1][1] - dots[0][1]) / (dots[1][0] - dots[0][0]);
        double slopB = (double) (dots[3][1] - dots[2][1]) / (dots[3][0] - dots[2][0]);
        if (slopA == slopB) return 1;

        slopA = (double) (dots[2][1] - dots[0][1]) / (dots[2][0] - dots[0][0]);
        slopB = (double) (dots[3][1] - dots[1][1]) / (dots[3][0] - dots[1][0]);
        if (slopA == slopB) return 1;

        slopA = (double) (dots[3][1] - dots[0][1]) / (dots[3][0] - dots[0][0]);
        slopB = (double) (dots[2][1] - dots[1][1]) / (dots[2][0] - dots[1][0]);
        if (slopA == slopB) return 1;

        return 0;
    }
}
