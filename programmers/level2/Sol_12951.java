package programmers.level2;

public class Sol_12951 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] str = s.toLowerCase().split("");
        boolean isSpace = true;

        for (String ss : str) {
            if (isSpace) answer.append(ss.toUpperCase());
            else answer.append(ss);
            isSpace = ss.isBlank();
        }

        return String.valueOf(answer);
    }
}
