import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int aCnt = 0, bCnt = 0, cCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == a[i % a.length]) aCnt++;
            if (answer == b[i % b.length]) bCnt++;
            if (answer == c[i % c.length]) cCnt++;
        }
        int max = Math.max(Math.max(aCnt, bCnt), cCnt);
        List<Integer> answer = new ArrayList<>();
        if (max == aCnt) answer.add(1);
        if (max == bCnt) answer.add(2);
        if (max == cCnt) answer.add(3);
        return answer.stream().mapToInt(e -> e).toArray();
    }
}