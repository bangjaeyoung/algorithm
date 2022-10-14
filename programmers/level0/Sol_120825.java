package programmers.level0;

public class Sol_120825 {
    public String solution(String myString, int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {
            sb.append(String.valueOf(myString.charAt(i)).repeat(n));
        }

        return String.valueOf(sb);
    }
}
