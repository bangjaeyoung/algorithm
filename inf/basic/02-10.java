import java.io.*;
import java.util.*;

public class Main {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    private int solution(int n, int[][] arr) {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (arr[nx][ny] >= arr[i][j]) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag) ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(main.solution(n, arr));
    }
}
