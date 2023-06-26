package 프로그래머스.lv0;

public class Sol_120892 {
    public String solution(String cipher, int code) {

        StringBuilder sb = new StringBuilder();

        for (int i = code - 1; i < cipher.length(); ) {
            sb.append(cipher.charAt(i));
            i += code;
        }

        return String.valueOf(sb);
    }
}
