package programmers.level1;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sol_12932 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(1234567)));
    }
}

class Solution {
    public int[] solution(long n) {

        String str = String.valueOf(n);

        StringBuilder sb = new StringBuilder(str);

        String[] reverse = sb.reverse().toString().split("");

        return Arrays.stream(reverse).mapToInt(Integer::parseInt).toArray();
    }
}
