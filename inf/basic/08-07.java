import java.util.Scanner;

public class Main {
    static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        memo = new int[n+1][r+1];

        System.out.print(dfs(n, r));
    }

    private static int dfs(int n, int r) {
        if (memo[n][r] != 0) return memo[n][r];

        if (n == r || r == 0) return 1;
        else {
            return memo[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
        }
    }
}
