package programmers.level1;

public class Sol_12903 {

    public String solution(String s) {

        // 단어 길이가 짝수일 경우, 가운데 두 글자 반환
        if (s.length() % 2 == 0) {
            return String.valueOf(s.charAt(s.length() / 2 - 1)) + s.charAt(s.length() / 2);
        }

        // 단어 길이가 홀수일 경우, 가운데 한 글자 반환
        return String.valueOf(s.charAt(s.length() / 2));
    }
}
