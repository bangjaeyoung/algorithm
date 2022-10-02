package programmers.level1;

import java.util.Arrays;

// 문자열을 내림차순으로 배치하라.
// 1. 인자로 받은 문자열을 char 타입의 배열로 쪼갬
// 2. 배열의 요소들을 오름차순으로 정렬
// 3. 배열을 문자열로 생성하고, 뒤집어서 반환
public class Sol_12917 {
    public String solution(String s) {

        // 1. 인자로 받은 문자열을 char 타입의 배열로 쪼갬
        char[] sArr = s.toCharArray();

        // 2. 배열의 요소들을 오름차순으로 정렬
        Arrays.sort(sArr);

        // 3. 배열을 문자열로 생성하고, 뒤집어서 반환
        return new StringBuilder(new String(sArr)).reverse().toString();
    }
}
