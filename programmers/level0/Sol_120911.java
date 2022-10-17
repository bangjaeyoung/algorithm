package programmers.level0;

import java.util.Arrays;

public class Sol_120911 {
    public String solution(String my_string) {

        char[] charArr = my_string.toLowerCase().toCharArray();
        Arrays.sort(charArr);

        return new String(charArr);
    }
}
