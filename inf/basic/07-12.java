import java.util.Scanner;

public class Main {
    static int[][] graph;
    static int[] chk;
    static int n, m, ans = 0;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        chk = new int[n+1];
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt(), to = sc.nextInt();
            graph[from][to] = 1;
        }
        chk[1] = 1;
        main.dfs(1);
        System.out.print(ans);
    }

    private void dfs(int v) {
        if (v == n)
            ans++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && chk[i] == 0) {
                    chk[i] = 1;
                    dfs(i);
                    chk[i] = 0;
                }
            }
        }
    }
}
