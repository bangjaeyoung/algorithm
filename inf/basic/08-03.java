import java.util.Scanner;

public class Main {
    static int n, m, answer = Integer.MIN_VALUE;
    static int[][] problems;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        problems = new int[n][2];

        for (int i = 0; i < n; i++) {
            problems[i][0] = sc.nextInt();
            problems[i][1] = sc.nextInt();
        }

        dfs(0, 0, 0);
        System.out.print(answer);
    }

    private static void dfs(int level, int sum, int time) {
        if (time > m) return;
        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level + 1, sum + problems[level][0], time + problems[level][1]);
            dfs(level + 1, sum, time);
        }
    }
}
