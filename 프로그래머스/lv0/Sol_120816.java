package 프로그래머스.lv0;

public class Sol_120816 {
    public int solution(int slice, int n) {

        int count = 1;

        while (true) {
            if (slice * count >= n) {
                return count;
            }
            count++;
        }
    }
}
