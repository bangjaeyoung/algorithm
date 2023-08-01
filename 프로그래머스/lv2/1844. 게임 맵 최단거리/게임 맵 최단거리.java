import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] distance;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        distance = new int[n][m];
        distance[0][0] = 1;
        bfs(0, 0, maps);

        return distance[n-1][m-1] == 0 ? -1 : distance[n-1][m-1];
    }

    private void bfs(int i, int j, int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        maps[i][j] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = now.x + dx[k];
                int nextY = now.y + dy[k];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (maps[nextX][nextY] != 0) {
                        maps[nextX][nextY] = 0;
                        distance[nextX][nextY] = distance[now.x][now.y] + 1;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }
}