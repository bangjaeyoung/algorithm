package programmers.level0;

import java.util.Arrays;

public class Sol_120886 {
    public int solution(String before, String after) {

        char[] charBefore = before.toCharArray();
        char[] charAfter = after.toCharArray();

        Arrays.sort(charBefore);
        Arrays.sort(charAfter);

        return new String(charBefore).equals(new String(charAfter)) ? 1 : 0;
    }
}
