package programmers.level1;

import java.util.Arrays;

class Sol_12919 {

    public String solution(String[] seoul) {

        // 리스트의 요소 중에 "Kim"의 인덱스 찾기
        int kimIndex = Arrays.asList(seoul).indexOf("Kim");

        // 결과 문구 반환
        return "김서방은 " + kimIndex + "에 있다";
    }
}
