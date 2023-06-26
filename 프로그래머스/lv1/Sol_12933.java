package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class Sol_12933 {
    public long solution(long n) {

        String[] str = Long.toString(n).split("");

        Arrays.sort(str, Comparator.reverseOrder());

        StringBuilder answer = new StringBuilder();

        for (String s : str) {
            answer.append(s);
        }

        return Long.parseLong(String.valueOf(answer));
    }
}
