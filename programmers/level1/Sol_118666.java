package programmers.level1;

public class Sol_118666 {
    public String solution(String[] survey, int[] choices) {
        int[] alphabet = new int[26];

        // 점수 기록
        for (int i = 0; i < survey.length; i++) {
            switch (choices[i]) {
                case 1:
                case 2:
                case 3:
                    alphabet[survey[i].charAt(0) - 65] += (4 - choices[i]);
                    break;
                case 5:
                case 6:
                case 7:
                    alphabet[survey[i].charAt(1) - 65] += (choices[i] - 4);
                    break;
                default:
                    break;
            }
        }

        int scoreOfR = alphabet[17];
        int scoreOfT = alphabet[19];
        int scoreOfC = alphabet[2];
        int scoreOfF = alphabet[5];
        int scoreOfJ = alphabet[9];
        int scoreOfM = alphabet[12];
        int scoreOfA = alphabet[0];
        int scoreOfN = alphabet[13];

        StringBuilder result = new StringBuilder();

        if (scoreOfR >= scoreOfT) result.append("R");
        else result.append("T");
        if (scoreOfC >= scoreOfF) result.append("C");
        else result.append("F");
        if (scoreOfJ >= scoreOfM) result.append("J");
        else result.append("M");
        if (scoreOfA >= scoreOfN) result.append("A");
        else result.append("N");

        return String.valueOf(result);
    }
}
