import java.io.*;
import java.util.*;

class Point {
    int x, y, z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    static int M, N, H;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] storage;
    static int[][][] day;   // 익는 데까지 걸리는 날짜를 기록할 배열
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        storage = new int[H][N][M];
        day = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    storage[i][j][k] = Integer.parseInt(st.nextToken());

                    // 토마토가 있다면 큐에 추가
                    if (storage[i][j][k] == 1) {
                        queue.offer(new Point(k, j, i));
                    }
                }
            }
        }

        bfs();

        boolean isRaw = false;
        outerLoop:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 익지 않은 토마토가 있는 경우
                    if (storage[i][j][k] == 0) {
                        isRaw = true;
                        break outerLoop;
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        // 익지 않은 토마토가 없는 경우
        if (!isRaw) {
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        answer = Math.max(answer, day[i][j][k]);
                    }
                }
            }
            System.out.print(answer);
        }
        // 익지 않은 토마토가 있는 경우
        else {
            System.out.print(-1);
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point now = queue.poll();

                for (int j = 0; j < 6; j++) {
                    int nextX = now.x + dx[j];
                    int nextY = now.y + dy[j];
                    int nextZ = now.z + dz[j];

                    if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && nextZ >= 0 && nextZ < H) {
                        if (storage[nextZ][nextY][nextX] == 0) {
                            // 익은 토마토로 변경
                            storage[nextZ][nextY][nextX] = 1;
                            // 이전 지점의 날짜에 하루를 더함
                            day[nextZ][nextY][nextX] = day[now.z][now.y][now.x] + 1;
                            queue.offer(new Point(nextX, nextY, nextZ));
                        }
                    }
                }
            }
        }
    }
}
