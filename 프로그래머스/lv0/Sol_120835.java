package 프로그래머스.lv0;

public class Sol_120835 {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                int idx = 1;
                for (int j = 0; j < answer.length; j++) {
                    if (emergency[i] < emergency[j]) idx++;
                }
                answer[i] = idx;
            }
        }
        return answer;
    }
}
