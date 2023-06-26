package 프로그래머스.lv0;

public class Sol_120876 {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] num = new int[200];

        for (int[] line : lines) {
            int minNum = Math.min(line[0], line[1]);
            int maxNum = Math.max(line[0], line[1]);
            for (int i = minNum; i < maxNum; i++) {
                num[i + 100]++;
            }
        }

        for (int n : num) {
            if (n > 1) {
                answer++;
            }
        }
        return answer;
    }
}
