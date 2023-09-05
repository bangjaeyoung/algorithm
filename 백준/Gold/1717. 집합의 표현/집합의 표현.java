import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = i;

        StringBuilder sb = new StringBuilder();
        int command, a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            command = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else {
                sb.append((isSameSet(a, b) ? "YES" : "NO")).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            arr[a] = b;
        }
    }

    private static int find(int a) {
        if (a == arr[a])
            return a;
        
        return arr[a] = find(arr[a]);
    }

    private static boolean isSameSet(int a, int b) {
        a = find(a);
        b = find(b);

        return a == b;
    }
}
