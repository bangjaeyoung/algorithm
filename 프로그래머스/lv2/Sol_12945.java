package programmers.level2;

import java.util.ArrayList;

public class Sol_12945 {
    public int solution(int num) {
        ArrayList<Integer> memo = new ArrayList<>();

        memo.add(0);
        memo.add(1);

        return aux(memo, num);
    }

    static int aux(ArrayList<Integer> memo, int num) {
        if (memo.size() <= num) {
            memo.add((aux(memo, num - 1) % 1234567 + aux(memo, num - 2) % 1234567) % 1234567);
        }

        return memo.get(num);
    }
}
