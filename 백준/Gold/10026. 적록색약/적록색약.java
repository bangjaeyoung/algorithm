import java.io.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, cnt = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] map, copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        copyMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
                copyMap[i][j] = map[i][j];
            }
        }

        // 적록색약 아닌 사람이 볼 때
        countArea(copyMap);

        answer.append(cnt).append(" ");

        cnt = 0;

        // 적록색약인 사람이 볼 때
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // G(초록색)을 R(빨간색)으로 변환
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        countArea(map);

        answer.append(cnt);

        System.out.println(answer);
    }

    private static void countArea(char[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 'X') {
                    dfs(map, i, j);
                    cnt++;
                }
            }
        }
    }

    private static void dfs(char[][] map, int x, int y) {
        char currentColor = map[x][y];
        map[x][y] = 'X';

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                if (map[nextX][nextY] == currentColor) {
                    dfs(map, nextX, nextY);
                }
            }
        }
    }
}
