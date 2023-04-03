import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        l -= 1;
        int idx = 0;
        int answer = 1;
        for (int i = idx + 1; i < n; i++) {
            if (arr[i] - arr[idx] > l) {
                answer++;
                idx = i;
            }
        }
        if (l == 0) answer = arr.length;

        System.out.println(answer);
    }
}