import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int tmp = 1;
        while (!q.isEmpty()) {
            int num = q.poll();
            if (q.isEmpty()) {
                sb.append(num).append(">");
                break;
            }
            if (tmp == k) {
                sb.append(num).append(", ");
                tmp = 1;
            } else {
                q.offer(num);
                tmp++;
            }
        }
        System.out.println(sb);
    }
}