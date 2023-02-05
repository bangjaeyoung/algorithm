package programmers.level2;

import java.util.Arrays;

public class Sol_42747 {
    public int solution(int[] citations) {
        int h = 0;
        int temp;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            temp = citations.length - i;

            if (citations[i] >= temp) {
                h = temp;
                break;
            }
        }

        return h;
    }
}
