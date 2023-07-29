import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] chk;
    static int n, m, ans = 0;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        chk = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt(), to = sc.nextInt();
            graph.get(from).add(to);
        }
        chk[1] = 1;
        main.dfs(1);
        System.out.print(ans);
    }

    private void dfs(int v) {
        if (v == n)
            ans++;
        else {
            for (int nv : graph.get(v)) {
                if (chk[nv] == 0) {
                    chk[nv] = 1;
                    dfs(nv);
                    chk[nv] = 0;
                }
            }
        }
    }
}
