import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S, ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr);

        if (ans == Integer.MAX_VALUE)
            System.out.println("0");
        else
            System.out.println(ans);
    }

    private static void solve(int[] arr) {
        int startIdx = 0, endIdx = 0, sum = 0;

        while (startIdx <= N && endIdx <= N) {
            if (sum >= S && ans > endIdx - startIdx)
                ans = endIdx - startIdx;

            if (sum < S)
                sum += arr[endIdx++];
            else
                sum -= arr[startIdx++];
        }
    }
}
