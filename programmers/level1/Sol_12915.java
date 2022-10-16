package programmers.level1;

import java.util.Arrays;

// 1. 입력 받은 문자열 배열의 문자들 맨 앞에 인덱스 n 문자를 붙여 새로운 문자열 배열을 생성
// 2. 새로 생성한 배열의 문자들을 오름차순으로 정렬
// 3. 맨 앞 문자를 뺀 문자열의 배열을 반환
class Sol_12915 {
    public String[] solution(String[] strings, int n) {

        String[] strArr = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            strArr[i] = strings[i].charAt(n) + strings[i];
        }
        Arrays.sort(strArr);

        String[] answer = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            answer[i] = strArr[i].substring(1);
        }

        return answer;
    }
}
