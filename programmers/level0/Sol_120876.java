package programmers.level0;

public class Sol_120876 {
    public static int solution(int lines[][]) {
        int minNum = 100;
        int maxNum = -100;
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                if (lines[i][j] < minNum) {
                    minNum = lines[i][j];
                }
                if (lines[i][j] > maxNum) {
                    maxNum = lines[i][j];
                }
            }
        }
        if (minNum < 0) {
            for (int i = 0; i < lines.length; i++) {
                for (int j = 0; j < lines[i].length; j++) {
                    lines[i][j] += Math.abs(minNum);
                }
            }
        }

        int[] numCheck = new int[maxNum - minNum + 2];

        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0]; j <= lines[i][1]; j++) {
                numCheck[j]++;
            }
        }

        int lengthOfOverlappingLine = 0;
        for (int i = 0; i < numCheck.length - 1; i++) {
            if (numCheck[i] > 1) {
                if (numCheck[i + 1] > 1) {
                    lengthOfOverlappingLine++;
                }
            }
        }
        return lengthOfOverlappingLine;
    }

    public static void main(String[] args) {
        int[][] ex = {{-1, 0}, {0, 1}, {1, 2}};
        System.out.println(solution(ex));
    }
}
