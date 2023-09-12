import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[50_002];

        int a, b;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[i] = b;
        }

        solve(n, arr);

        System.out.println(ans);
    }

    private static void solve(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
                ans++;
            }

            if (!stack.isEmpty() && stack.peek() == arr[i]) continue;

            stack.push(arr[i]);
        }
    }
}
