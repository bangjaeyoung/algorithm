import java.util.Scanner;

public class Main {
    static int n, f;
    static int[] combination, permutation;
    static boolean[] check;
    static int[][] memo;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        combination = new int[n];
        permutation = new int[n];
        check = new boolean[n+1];
        memo = new int[n+1][n+1];

        for (int i = 0; i <= n-1; i++) {
            combination[i] = combi(n-1, i);
        }

        dfs(0, 0);
    }

    // n-1에 대한 조합 구하기
    private static int combi(int n, int r) {
        if (memo[n][r] > 0) return memo[n][r];

        if (n == r || r == 0) return 1;
        else {
            return memo[n][r] = combi(n-1, r-1) + combi(n-1, r);
        }
    }

    // 1~n까지 순열 구하기
    private static void dfs(int level, int sum) {
        if (flag || sum > f) return;

        if (level == n) {
            if (sum == f) {
                for (int p : permutation) {
                    System.out.print(p + " ");
                    flag = true;
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    permutation[level] = i;
                    dfs(level + 1, sum + (combination[level] * permutation[level]));
                    check[i] = false;
                }
            }
        }
    }
}
