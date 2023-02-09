package programmers.level2;

public class Sol_12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowLengthOfArr1 = arr1.length;
        int columnLengthOfArr2 = arr2[0].length;
        int[][] answer = new int[rowLengthOfArr1][columnLengthOfArr2];

        for (int i = 0; i < rowLengthOfArr1; i++) {
            for (int j = 0; j < columnLengthOfArr2; j++) {
                int k = 0;

                while (k < arr1[0].length) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                    k++;
                }
            }
        }

        return answer;
    }
}
