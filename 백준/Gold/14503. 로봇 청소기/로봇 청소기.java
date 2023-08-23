import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int ans = 1, N, M;
    static int[][] room;
    static int[] dx = {-1, 0, 1, -0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);

        System.out.print(ans);
    }

    private static void dfs(int x, int y, int dir) {

        // 현재 지점을 청소한다.
        room[x][y] = -1;

        for (int i = 0; i < 4; i++) {

            // 왼쪽 방향으로 돌면서 탐색한다.
            dir = (dir + 3) % 4;

            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            // 청소가 되어 있지 않다면, 청소하기 위해 이동한다.
            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                if (room[nextX][nextY] == 0) {
                    ans++;
                    dfs(nextX, nextY, dir);

                    return;
                }
            }
        }

        // 더 이상 청소할 공간이 없을 경우
        int d = (dir + 2) % 4;
        int backX = x + dx[d];
        int backY = y + dy[d];

        // 방향을 유지한 채로 후진한다.
        if (backX >= 0 && backY >= 0 && backX < N && backY < M) {
            if (room[backX][backY] != 1) {
                dfs(backX, backY, dir);
            }
        }
    }
}
