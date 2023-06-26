package 프로그래머스.lv0;

public class Sol_120841 {
    public int solution(int[] dot) {

        // 제 1사분면
        if (dot[0] > 0 && dot[1] > 0) return 1;

            // 제 2사분면
        else if (dot[0] < 0 && dot[1] > 0) return 2;

            // 제 3사분면
        else if (dot[0] < 0 && dot[1] < 0) return 3;

            // 제 4사분면
        else return 4;
    }
}
