package programmers.level1;

import java.util.ArrayList;
import java.util.List;

class Sol_42840 {
    public int[] solution(int[] answer) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        // 삼인방의 각각 맞은 문제 수를 구하는 과정
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == a[i % a.length]) {
                score[0]++;
            }
            if (answer[i] == b[i % b.length]) {
                score[1]++;
            }
            if (answer[i] == c[i % c.length]) {
                score[2]++;
            }
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> result = new ArrayList<>();

        if (maxScore == score[0]) result.add(1);
        if (maxScore == score[1]) result.add(2);
        if (maxScore == score[2]) result.add(3);

        return result.stream().mapToInt(i -> i).toArray();
    }
}
