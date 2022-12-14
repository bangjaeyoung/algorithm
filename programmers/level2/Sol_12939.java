package programmers.level2;

import java.util.Arrays;

public class Sol_12939 {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        Arrays.sort(strArr);

        int minusCheck = 0;
        for (String str : strArr) {
            if (str.charAt(0) == '-') minusCheck++;
        }

        StringBuilder answer = new StringBuilder();
        if (minusCheck == strArr.length) {  // 모든 수가 음수일 경우
            answer.append(strArr[strArr.length - 1]).append(" ").append(strArr[0]);
        } else {
            answer.append(strArr[0]).append(" ").append(strArr[strArr.length - 1]);
        }

        return String.valueOf(answer);
    }
}
