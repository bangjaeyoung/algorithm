package 프로그래머스.lv0;

public class Sol_120860 {
    public int solution(int[][] dots) {
        int answer = 0;
        int[] dot = dots[0];

        for (int i = 0; i < dots.length; i++) {
            int x = dots[i][0];
            int y = dots[i][1];

            if (dot[0] != x && dot[1] != y) {
                answer = Math.abs(x - dot[0]) * Math.abs(y - dot[1]);
                break;
            }
        }

        return answer;
    }
}
