package programmers.level1;

public class Sol_131128 {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        for (int i = 0; i < X.length(); i++) countX[X.charAt(i) - 48]++;
        for (int i = 0; i < Y.length(); i++) countY[Y.charAt(i) - 48]++;

        StringBuilder result = new StringBuilder();

        for (int i = countX.length - 1; i >= 0; i--) {
            while (countX[i] > 0 && countY[i] > 0) {
                result.append(i);
                countX[i]--;
                countY[i]--;
            }
        }

        if (result.length() == 0)
            return "-1";
        else if (result.charAt(0) == '0')
            return "0";
        else return String.valueOf(result);
    }
}
