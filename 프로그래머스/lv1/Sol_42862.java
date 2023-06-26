// ***** 다시 풀어보면 좋을 문제 *****

package programmers.level1;

import java.util.Arrays;

public class Sol_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 기본적으로 체육복이 있는 학생 수
        int answer = n - lost.length;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                // 먼저 여벌이 있는 학생이 도난 당한 경우부터 체크
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -3;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for (int lo : lost) {
            for (int j = 0; j < reserve.length; j++) {
                // 그 후에 빌려줄 수 있는 학생의 경우 체크
                if (lo + 1 == reserve[j] || lo - 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
