package programmers.level1;

// 인자로 받은 문자열의 각 단어의 짝수번째 문자는 대문자, 홀수번째 문자는 소문자로 바꾸어 반환하라.
// 1. 문자열을 띄어쓰기를 구분자로 쪼개어 문자열 배열 생성 ["try", "hello", "world"]
// 2. 이중 for문 생성
// 2-1. 외부 for문은 문자열 배열 요소를 돌고, 하나의 요소가 끝나면 공백 추가
// 2-2. 내부 for문은 각 요소의 문자를 돌면서, StringBuilder에 대문자로 변환한 문자와 그렇지 않은 문자들을 추가
// 3. 마지막에 추가된 공백은 다시 제거한 후, StringBuilder 반환
class Sol_12930 {

    public String solution(String s) {

        // 인자로 받은 문자열을 모두 소문자로 변환
        String str = s.toLowerCase();

        // 공백으로 구분하여, 문자열 배열 생성
        String[] sArr = str.split(" ", -1);
        // -1을 인자값으로 넣어주면, 마지막 비어있는 값 인식

        StringBuilder sb = new StringBuilder();

        for (String st : sArr) {

            for (int j = 0; j < st.length(); j++) {

                if (j % 2 == 0) {   // 짝수번째
                    sb.append((char) (st.charAt(j) - 32)); // 'a'와 'A'는 32 차이
                } else {    // 홀수번째
                    sb.append(st.charAt(j));
                }
            }

            sb.append(' ');
        }

        sb.deleteCharAt(sb.length() - 1);   // 마지막 공백 제거

        return sb.toString();
    }
}
