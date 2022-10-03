package programmers.level1;

// 문자열 s의 길이가 4 또는 6이고, 숫자로만 구성되어있는지 boolean 함수
public class Sol_12918 {
    public boolean solution(String s) {

        boolean answer = false;

        if (s.length() == 4 || s.length() == 6) {

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    answer = true;
                }
                else return false;
            }
        }
        return answer;
    }
}
