import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    private static void dfs(int row, int col, int sum, int cnt) {

        if (cnt == 4)
            max = Math.max(max, sum);

        else {
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < M) {
                    if (!visited[nextRow][nextCol]) {

                        // 'ㅜ' 모양의 테트로미노일 경우, 탐색을 한 번 더 한다.
                        if (cnt == 2) {
                            visited[nextRow][nextCol] = true;
                            dfs(row, col, sum + map[nextRow][nextCol], cnt + 1);
                            visited[nextRow][nextCol] = false;
                        }

                        visited[nextRow][nextCol] = true;
                        dfs(nextRow, nextCol, sum + map[nextRow][nextCol], cnt + 1);
                        visited[nextRow][nextCol] = false;
                    }
                }
            }
        }
    }
}
