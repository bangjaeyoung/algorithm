import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(n, arr));
    }

    private int solution(int n, int[] arr) {
        int ans = 0, tmp = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) ans += ++tmp;
            else tmp = 0;
        }

        return ans;
    }
}
