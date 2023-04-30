import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<Integer> idx = new LinkedList<>();
            Queue<Integer> printer = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                idx.offer(j);
                printer.offer(Integer.parseInt(st.nextToken()));
            }
            int count = 1;
            while (!printer.isEmpty()) {
                int max = Collections.max(printer);
                int now = printer.poll();
                int nowIdx = idx.poll();
                if (now == max) {
                    if (nowIdx == m) {
                        sb.append(count).append("\n");
                        break;
                    }
                    count++;
                } else {
                    printer.offer(now);
                    idx.offer(nowIdx);
                }
            }
        }
        System.out.println(sb);
    }
}