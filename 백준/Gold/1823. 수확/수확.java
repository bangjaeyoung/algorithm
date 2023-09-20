import java.io.*;

public class Main {
    static int[] plants;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        plants = new int[N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            plants[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(0, N-1, 1));
    }

    private static int solve(int left, int right, int cnt) {
        if (left > right) return 0;

        if (dp[left][right] != 0) return dp[left][right];

        int res1 = solve(left+1, right, cnt+1) + cnt*plants[left];
        int res2 = solve(left, right-1, cnt+1) + cnt*plants[right];

        dp[left][right] = Math.max(res1, res2);

        return dp[left][right];
    }
}
