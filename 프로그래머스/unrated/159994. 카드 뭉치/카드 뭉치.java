import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < goal.length; i++) {
            String str = goal[i];
            if (idx1 < cards1.length && str.equals(cards1[idx1])) {
                idx1++;
                continue;
            } else if (idx2 < cards2.length && str.equals(cards2[idx2])) {
                idx2++;
                continue;
            } else {
                return new String("No");
            }
        }
        return new String("Yes");
    }
}