import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String answer = "NO";
    static int n, total;
    static int[] arr;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        main.dfs(0, 0);
        System.out.println(answer);
    }

    private void dfs(int level, int sum) {
        if (flag || sum > total - sum) return;

        if (level == n) {
            if (sum == total - sum) {
                flag = true;
                answer = "YES";
            }
        } else {
            dfs(level + 1, sum + arr[level]);
            dfs(level + 1, sum);
        }
    }
}
