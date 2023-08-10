import java.io.*;
import java.util.*;

class Point {
    int x, y, distance, destroyCount;

    public Point(int x, int y, int distance, int destroyCount) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.destroyCount = destroyCount;   // 벽을 부신 횟수
    }
}

public class Main {
    static int n, m, answer;
    static int[][] map, destroyCounts;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        destroyCounts = new int[n][m];  // 벽은 부신 횟수를 저장할 배열

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
                destroyCounts[i][j] = Integer.MAX_VALUE;
            }
        }

        answer = Integer.MAX_VALUE;

        bfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(answer);
        }
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 1, 0));
        destroyCounts[x][y] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            // 목적지에 도착한 경우
            if (now.x == n - 1 && now.y == m - 1) {
                answer = now.distance;
                break;
            }

            for (int j = 0; j < 4; j++) {
                int nextX = now.x + dx[j];
                int nextY = now.y + dy[j];


                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    // 상하좌우 중 바로 이전의 경로 탐색은 생략
                    if (destroyCounts[nextX][nextY] <= now.destroyCount) continue;

                    // 통로인 경우
                    if (map[nextX][nextY] == 0) {
                        destroyCounts[nextX][nextY] = now.destroyCount;
                        queue.offer(new Point(nextX, nextY, now.distance + 1, now.destroyCount));
                    }
                    // 벽인 경우
                    else if (map[nextX][nextY] == 1) {
                        // 현재까지 벽을 부신 적이 없을 경우
                        if (now.destroyCount == 0) {
                            destroyCounts[nextX][nextY] = now.destroyCount + 1;
                            queue.offer(new Point(nextX, nextY, now.distance + 1, now.destroyCount + 1));
                        }
                    }
                }
            }
        }
    }
}
