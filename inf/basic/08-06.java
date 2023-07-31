import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, permutation;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        permutation = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
    }

    private static void dfs(int level) {
        if (level == m) {
            for (int p : permutation) {
                System.out.print(p + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    permutation[level] = arr[i];
                    visited[i] = true;
                    dfs(level + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
