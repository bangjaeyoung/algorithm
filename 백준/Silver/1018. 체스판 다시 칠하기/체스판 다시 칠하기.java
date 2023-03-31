import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] board;
    static int answer = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);
                if (ch == 'W') board[i][j] = true;
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                count(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void count(int startRow, int startCol) {
        boolean color = board[startRow][startCol];
        int count = 0;
        
        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                if (board[i][j] != color) {
                    count++;
                }
                
                color = !color;
            }
            
            color = !color;
        }

        count = Math.min(count, 64 - count);
        
        answer = Math.min(answer, count);
    }
}