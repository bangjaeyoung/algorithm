import java.io.*;
import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] board = new int[8][8];
    static int[][] distance = new int[8][8];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 7; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(1, 1);

        if (distance[7][7] == 0)
            System.out.print(-1);
        else
            System.out.print(distance[7][7]);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        board[x][y] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX >= 1 && nextY >= 1 && nextX <= 7 && nextY <= 7) {
                    if (board[nextX][nextY] == 0) {
                        board[nextX][nextY] = 1;
                        distance[nextX][nextY] = distance[now.x][now.y] + 1;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }
}
