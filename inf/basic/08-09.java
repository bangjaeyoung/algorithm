import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] combination;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combination = new int[m];

        dfs(0, 1);
    }

    private static void dfs(int level, int start) {
        if (level == n) {
            for (int c : combination) {
                System.out.print(c + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                combination[level] = i;
                dfs(level+1, i+1);
            }
        }
    }
}
