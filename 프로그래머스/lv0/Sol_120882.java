package 프로그래머스.lv0;

import java.util.Arrays;

public class Sol_120882 {
    public int[] solution(int[][] score) {
        int[] rank = new int[score.length];
        Arrays.fill(rank, 1);

        for (int[] ints : score) {
            for (int j = 0; j < score.length; j++) {
                if (ints[0] + ints[1] > score[j][0] + score[j][1]) {
                    rank[j]++;
                }
            }
        }
        return rank;
    }
}
