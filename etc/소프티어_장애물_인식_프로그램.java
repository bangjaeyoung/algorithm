import java.util.*;
import java.io.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n;
    static int[][] maps;
    static boolean[][] visited;
    static int number = 1;
    static int[][] blockMaps;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maps = new int[n][n];
        visited = new boolean[n][n];
        blockMaps = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                maps[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    number++;
                }
            }
        }

        int[] blockNumbers = new int[number];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (blockMaps[i][j] != 0) {
                    blockNumbers[blockMaps[i][j]]++;
                }
            }
        }

        System.out.println(number-1);

        Arrays.sort(blockNumbers);

        for (int i=1; i<number; i++) {
            System.out.println(blockNumbers[i]);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        blockMaps[x][y] = number;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        blockMaps[nextX][nextY] = number;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }
}
