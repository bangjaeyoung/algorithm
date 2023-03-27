package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_3085 {
    static int N;

    private static int count(char[][] board) {
        int totalCnt = 1;

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            // 가로 체크
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (cnt > totalCnt) {
                    totalCnt = cnt;
                }
            }
            cnt = 1;
            // 새로 체크
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                if (cnt > totalCnt) {
                    totalCnt = cnt;
                }
            }
        }

        return totalCnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 1;

        N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        // board 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                board[i][j] = c;
            }
        }

        if (count(board) == N) {
            ans = count(board);
            System.out.println(ans);
            return;
        }

        // 교체하면서 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char temp = board[i][j];

                if (j + 1 < N) {
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;

                    if (count(board) == N) {
                        ans = count(board);
                        System.out.println(ans);
                        return;
                    } else if (count(board) > ans) {
                        ans = count(board);
                    }
                    board[i][j + 1] = board[i][j];
                    board[i][j] = temp;
                }

                if (i + 1 < N) {
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;

                    if (count(board) == N) {
                        ans = count(board);
                        System.out.println(ans);
                        return;
                    } else if (count(board) > ans) {
                        ans = count(board);
                    }
                    board[i + 1][j] = board[i][j];
                    board[i][j] = temp;
                }
            }
        }

        System.out.println(ans);
    }
}
