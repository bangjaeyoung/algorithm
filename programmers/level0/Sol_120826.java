package programmers.level0;

public class Sol_120826 {
    public String solution(String myString, String letter) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) != letter.charAt(0)) {
                sb.append(myString.charAt(i));
            }
        }

        return sb.toString();
    }
}
