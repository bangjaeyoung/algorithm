package programmers.level1;

import java.util.*;

public class Sol_135808 {
    public int solution(int k, int m, int[] score) {
        int theGreatestProfit = 0;
        Arrays.sort(score);

        for (int i = score.length; i >= m; i -= m) {
            theGreatestProfit += (score[i - m] * m);
        }
        return theGreatestProfit;
    }
}
