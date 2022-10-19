package programmers.level1;

public class Sol_12916 {
    public boolean solution(String s) {

        String str = s.toLowerCase();

        int countP = 0;
        int countY = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'p') {
                countP++;
            }
            if (str.charAt(i) == 'y') {
                countY++;
            }
        }

        return countP == countY;
    }
}
