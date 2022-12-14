package programmers.level2;

import java.util.Arrays;

public class Sol_12939 {
    public String solution(String s) {
        Object[] intArr = Arrays.stream(s.split(" ")).map(Integer::parseInt).sorted().toArray();
        return intArr[0] + " " + intArr[intArr.length - 1];
    }
}
