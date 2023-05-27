import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int num = 1;
        int row = 0;
        int col = 0;
        int direction = 0;
        while (num <= n * (n + 1) / 2) {
            triangle[row][col] = num;
            num++;
            if (direction == 0) {
                if (row + 1 < n && triangle[row + 1][col] == 0) {
                    row++;
                } else {
                    direction = 1;
                    col++;
                }
            } else if (direction == 1) {
                if (col + 1 < n && triangle[row][col + 1] == 0) {
                    col++;
                } else {
                    direction = 2;
                    row--;
                    col--;
                }
            } else if (direction == 2) {
                if (row - 1 >= 0 && triangle[row - 1][col - 1] == 0) {
                    row--;
                    col--;
                } else {
                    direction = 0;
                    row++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result.add(triangle[i][j]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}