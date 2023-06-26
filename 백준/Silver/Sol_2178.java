package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol_2178 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        visited[0][0] = true;
        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = now[0] + dx[k];
                int nextY = now[1] + dy[k];
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (map[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = map[now[0]][now[1]] + 1;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
