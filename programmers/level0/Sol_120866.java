package programmers.level0;

import java.util.Arrays;

public class Sol_120866 {
    public int solution(int[][] board) {
        int answer = 0;
        int dangerZone = 1;

        int[][] copyBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int temp = board[i][j];

                if (temp == 0) continue;
                makeDangerArea(i, j, dangerZone, copyBoard);
            }
        }

        for (int i = 0; i < copyBoard.length; i++) {
            for (int j = 0; j < copyBoard[i].length; j++) {
                if (copyBoard[i][j] == 0)
                    answer++;
            }
        }

        return answer;
    }

    static void makeDangerArea(int row, int col, int dangerZone, int[][] board) {
        for (int i = row - dangerZone; i <= row + dangerZone; i++) {
            if (i < 0 || i >= board.length) continue;

            for (int j = col - dangerZone; j <= col + dangerZone; j++) {
                if (j < 0 || j >= board[0].length) continue;

                board[i][j] = 1;
            }
        }
    }
}
