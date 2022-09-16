package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_2775 {

    public static int[][] apt = new int[15][15];      // 0층부터 14층, 0호부터 14호

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        makeApt();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n]).append("\n");
        }
        System.out.println(sb);
    }

    // 모든 층의 모든 호에 값들을 할당
    public static void makeApt() {

        for (int i = 1; i < 15; i++) {
            apt[0][i] = i;      // 0층 i호
            apt[i][1] = 1;      // i층 1호
        }

        for (int i = 1; i < 15; i++) {      // 0층의 모든 호수들은 값이 할당 되었으므로, 1층부터 14층까지

            for (int j = 2; j < 15; j++) {      // 모든 층의 1호들은 값이 할당되었으므로, 2호부터 14층까지

                apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
            }
        }
    }
}
