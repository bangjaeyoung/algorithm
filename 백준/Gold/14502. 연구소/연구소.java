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
    static int n, m, answer = Integer.MIN_VALUE;
    static int[][] lab, copyLab;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][m];
        copyLab = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        
        System.out.print(answer);
    }

    // 벽 3개를 세우는 메서드
    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            copyArr();
            bfs();
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (lab[i][j] == 0) {
                        lab[i][j] = 1;
                        dfs(wallCount + 1);
                        lab[i][j] = 0;
                    }
                }
            }
        }
    }

    // 2차원 배열을 복사하는 메서드
    private static void copyArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyLab[i][j] = lab[i][j];
            }
        }
    }

    // 바이러스를 퍼뜨리는 메서드
    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyLab[i][j] == 2) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nextX = now.x + dx[j];
                    int nextY = now.y + dy[j];

                    if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                        if (copyLab[nextX][nextY] == 0) {
                            copyLab[nextX][nextY] = 2;
                            queue.offer(new Point(nextX, nextY));
                        }
                    }
                }
            }
        }

        countSafePoint();
    }

    // 안전 지역을 세고, 최대 개수를 갱신하는 메서드  
    private static void countSafePoint() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyLab[i][j] == 0) {
                    count++;
                }
            }
        }

        answer = Math.max(answer, count);
    }
}
