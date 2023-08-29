import java.io.*;
import java.util.*;

/**
 * 동서남북 방향 잘 살피기
 * 문제마다 보드판의 x, y 잘 구분하기
 */
public class Main {
    static int N, K, L, time = 0;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};    // 동 남 서 북
    static int[] dy = {1, 0, -1, 0};
    static Map<Integer, String> dirOfTime = new LinkedHashMap<>();
    static Queue<Integer[]> snake = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보드 설정
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        // 사과 위치 설정
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 1;
        }

        // (시간, 방향) 저장
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            dirOfTime.put(time, dir);
        }

        solve();

        System.out.println(time);
    }

    private static void solve() {
        int nowX = 0, nowY = 0;
        int nowDir = 0;
        snake.offer(new Integer[]{nowX, nowY});

        while (true) {
            int nextX = nowX + dx[nowDir];
            int nextY = nowY + dy[nowDir];
            time++;

            if (isFinish(nextX, nextY)) break;

            // 사과를 만나면, 먹고 이동
            if (board[nextX][nextY] == 1) {
                board[nextX][nextY] = 0;
                snake.offer(new Integer[]{nextX, nextY});
            }
            // 사과를 못 만나면, 그냥 이동
            else {
                snake.offer(new Integer[]{nextX, nextY});
                snake.poll();
            }

            // 방향 전환
            if (dirOfTime.containsKey(time)) {
                String dir = dirOfTime.get(time);

                // D일 경우, 오른쪽 90도
                if (dir.equals("D")) {
                    nowDir++;
                    if (nowDir == 4) nowDir = 0;
                }
                // L일 경우, 왼쪽 90도
                else {
                    nowDir--;
                    if (nowDir == -1) nowDir = 3;
                }
            }

            nowX = nextX;
            nowY = nextY;
        }
    }

    public static boolean isFinish(int nextX, int nextY) {
        // 벽에 부딪히는 경우, 종료
        if (nextX == -1 || nextY == -1 || nextX == N || nextY == N) {
            return true;
        }

        // 몸통에 부딪히는 경우, 종료
        for (Integer[] curArr : snake) {
            if (curArr[0] == nextX && curArr[1] == nextY) {
                return true;
            }
        }

        return false;
    }
}
