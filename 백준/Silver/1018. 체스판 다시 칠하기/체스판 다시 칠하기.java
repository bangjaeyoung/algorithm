import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static char[][] board;
    static char[][] copyBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        copyBoard = new char[n][m];


        // 보드 세팅
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);
                board[i][j] = ch;
                copyBoard[i][j] = ch;
            }
        }

        int answer = 64;

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int count = count(copyBoard, i, j);
                answer = Math.min(answer, count);
                initializeBoard();
            }
        }

        System.out.println(answer);
    }

    private static int count(char[][] board, int startRow, int startCol) {
        int count = 0;

        for (int i = startRow; i < startRow + 7; i++) {
            for (int j = startCol; j < startCol + 7; j++) {
                char now = board[i][j];

                if (now == board[i][j + 1]) {
                    count++;
                    if (now == 'B') board[i][j + 1] = 'W';
                    else board[i][j + 1] = 'B';
                }

                if (now == board[i + 1][j]) {
                    count++;
                    if (now == 'B') board[i + 1][j] = 'W';
                    else board[i + 1][j] = 'B';
                }
                
                if (i == startRow + 6 && j == startCol + 6) {
                    if (now != board[i + 1][j + 1]) count++;
                }
            }
        }

        return Math.min(count, 64 - count);
    }

    private static void initializeBoard() {
        for (int i = 0; i < copyBoard.length; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }
    }
}