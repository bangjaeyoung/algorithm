package 프로그래머스.lv0;

public class Sol_120893 {
    public String solution(String myString) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {

            if (Character.isUpperCase(myString.charAt(i))) {
                sb.append((char) (myString.charAt(i) + 32));
            }
            else {
                sb.append((char) (myString.charAt(i) - 32));   // 대문자와 소문자 아스키 코드 차이는 32
            }
        }

        return String.valueOf(sb);
    }
}
