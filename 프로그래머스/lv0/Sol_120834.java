package 프로그래머스.lv0;

public class Sol_120834 {
    public String solution(int age) {

        StringBuilder sb = new StringBuilder();

        String ageStr = String.valueOf(age);

        for (int i = 0; i < ageStr.length(); i++) {
            sb.append((char) (ageStr.charAt(i) + 49));
        }

        return sb.toString();
    }
}
