import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] permutation;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        permutation = new int[m];

        dfs(0);
    }

    private static void dfs(int level) {
        if (level == m) {
            StringBuilder sb = new StringBuilder();
            for (int p  : permutation) {
                sb.append(p).append(" ");
            }
            System.out.println(sb);
        } else {
            for (int i = 1; i <= n; i++) {
                permutation[level] = i;
                dfs(level + 1);
            }
        }
    }
}
