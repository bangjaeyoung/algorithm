package programmers.level1;

import java.util.Arrays;

public class Sol_12932 {

    public int[] solution(long n) {

        String str = String.valueOf(n);

        StringBuilder sb = new StringBuilder(str);

        String[] reverse = sb.reverse().toString().split("");

        return Arrays.stream(reverse).mapToInt(Integer::parseInt).toArray();
    }
}
