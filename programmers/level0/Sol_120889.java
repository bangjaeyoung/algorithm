package programmers.level0;

public class Sol_120889 {
    public int solution(int[] sides) {

        int sum = 0;
        int max = 0;

        for (int side : sides) {
            if (side > max) max = side;
            sum += side;
        }

        sum -= max;

        return max < sum ? 1 : 2;
    }
}
