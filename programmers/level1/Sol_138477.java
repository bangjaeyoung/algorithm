package programmers.level1;

import java.util.PriorityQueue;

public class Sol_138477 {
    public int[] solution(int k, int[] score) {
        int[] result = new int[score.length];

        PriorityQueue<Integer> scoreList = new PriorityQueue<>();

        for(int i = 0; i < score.length; i++) {
            scoreList.add(score[i]);

            if (scoreList.size() > k) {
                scoreList.poll();
            }
            if (!scoreList.isEmpty())
                result[i] = scoreList.peek();
        }
        return result;
    }
}
