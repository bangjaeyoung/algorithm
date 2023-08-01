import java.io.*;
import java.util.*;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[][] board;
    static int[][] day;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        day = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && day[i][j] == 0) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        bfs();

        int answer = 0;
        boolean flag = true;
        Loop :
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && day[i][j] == 0) {
                    answer = -1;
                    flag = false;
                    break Loop;
                }
            }
        }

        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, day[i][j]);
                }
            }
        }

        System.out.print(answer);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nextX = now.x + dx[j];
                    int nextY = now.y + dy[j];

                    if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                        if (day[nextX][nextY] == 0 && board[nextX][nextY] == 0) {
                            board[nextX][nextY] = 1;
                            day[nextX][nextY] = day[now.x][now.y] + 1;
                            queue.offer(new Point(nextX, nextY));
                        }
                    }
                }
            }
        }
    }
}