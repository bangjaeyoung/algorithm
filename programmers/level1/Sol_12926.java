package programmers.level1;

// 1. StringBuilder 생성
// 2. for문을 통해 문자열을 순회
// 2-1. 공백일 경우, 공백 그대로 추가
// 2-2. 대문자인 경우, 문자+n 값이 'a'~'z'까지인 경우와 범위를 초과한 경우로 나누고 조건에 맞게 추가
// 2-3. 소문자인 경우, 문자+n 값이 'a'~'z'까지인 경우와 범위를 초과한 경우로 나누고 조건에 맞게 추가
// 3. 모두 추가된 결과를 String 타입으로 변환하여 반환
public class Sol_12926 {
    public String solution(String s, int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // 문자가 공백일 경우
            if (ch == ' ') {
                sb.append(' ');
            }

            // 문자가 대문자일 경우
            else if ((int) ch >= 65 && (int) ch <= 90) {

                // (문자+n) 값이 대문자 범위를 초과할 경우
                if (ch + n > 90) {
                    sb.append((char) (ch + n - 26));
                }
                // (문자+n) 값이 대문자 범위를 안일 경우
                else {
                    sb.append((char) (ch + n));
                }
            }

            // 문자가 소문자일 경우
            else if ((int) ch >= 97 && (int) ch <= 122) {

                // (문자+n) 값이 소문자 범위를 초과할 경우
                if (ch + n > 122) {
                    sb.append((char) (ch + n - 26));
                }
                // (문자+n) 값이 소문자 범위를 안일 경우
                else {
                    sb.append((char) (ch + n));
                }
            }
        }

        return String.valueOf(sb);
    }
}
