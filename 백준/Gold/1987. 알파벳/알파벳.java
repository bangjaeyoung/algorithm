import java.io.*;
import java.util.StringTokenizer;

/**
 * DFS(깊이 우선 탐색), 백트래킹
 */
public class Main {
    static int R, C, answer = 0;
    static int[][] board;
    static boolean[] isUsedAlphabet = new boolean[26];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                // board 배열에 해당 알파벳의 아스키 코드 값을 넣음. boolean 배열로 체크하기 용이하도록.
                board[i][j] = line.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count) {
        // 중복된 알파벳을 지나는 경우
        if (isUsedAlphabet[board[x][y]]) {
            answer = Math.max(answer, count);
        } else {
            isUsedAlphabet[board[x][y]] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C) {
                    dfs(nextX, nextY, count + 1);
                }
            }

            isUsedAlphabet[board[x][y]] = false;
        }
    }
}
