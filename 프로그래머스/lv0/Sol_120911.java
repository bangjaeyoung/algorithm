package 프로그래머스.lv0;

import java.util.Arrays;

public class Sol_120911 {
    public String solution(String my_string) {

        char[] charArr = my_string.toLowerCase().toCharArray();
        Arrays.sort(charArr);

        return new String(charArr);
    }
}
