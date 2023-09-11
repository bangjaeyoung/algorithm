import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[][] topni;
    static boolean[] isRotated;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        topni = new int[T][8];
        isRotated = new boolean[T];

        for (int i = 0; i < T; i++) {
            String line = br.readLine();

            for (int j = 0; j < 8; j++) {
                topni[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        int n, dir;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()) - 1;
            dir = Integer.parseInt(st.nextToken());

            check(n, dir);
            isRotated = new boolean[T];
        }

        // 12시 방향이 S극인 톱니바퀴 개수
        int cnt = 0;
        for (int i = 0; i < T; i++) {
            if (topni[i][0] == 1) cnt++;
        }

        System.out.println(cnt);
    }

    // 특정 톱니바퀴, 인접한 톱니바퀴 회전
    private static void check(int n, int dir) {
        isRotated[n] = true;
        rotate(n, dir);

        // 특정 톱니바퀴의 왼쪽 톱니바퀴
        if (n - 1 >= 0 && !isRotated[n - 1] && topni[n][dir + 6] != topni[n - 1][2]) {
            check(n - 1, dir * -1);
        }
        // 특정 톱니바퀴의 오른쪽 톱니바퀴
        if (n + 1 < T && !isRotated[n + 1] && topni[n][dir + 2] != topni[n + 1][6]) {
            check(n + 1, dir * -1);
        }
    }

    // 회전
    public static void rotate(int n, int dir) {
        // 시계 방향으로 회전
        if (dir == 1) {
            int tmp = topni[n][7];
            for (int i = 7; i >= 1; i--) {
                topni[n][i] = topni[n][i - 1];
            }
            topni[n][0] = tmp;
        }

        // 반시계 방향으로 회전
        else if (dir == -1) {
            int tmp = topni[n][0];
            for (int i = 0; i < 7; i++) {
                topni[n][i] = topni[n][i + 1];
            }
            topni[n][7] = tmp;
        }
    }
}
