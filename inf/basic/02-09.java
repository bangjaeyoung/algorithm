import java.io.*;
import java.util.*;

public class Main {
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

    private int solution(int n, int[][] arr) {
        int ans = Integer.MIN_VALUE;
        int sum1, sum2;

        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];  // 각 행 합
                sum2 += arr[j][i];  // 각 열 합
            }
            ans = Math.max(ans, sum1);
            ans = Math.max(ans, sum2);
        }

        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];  // 대각선 1 합
            sum2 += arr[i][n-i-1];  // 대각선 2 합
        }
        ans = Math.max(ans, sum1);
        ans = Math.max(ans, sum2);

        return ans;
    }
}
