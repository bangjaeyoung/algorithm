import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(time, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(time[0][1]);
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= time[i][0]) {
                pq.poll();
            }
            pq.offer(time[i][1]);
        }
        
        System.out.println(pq.size());
    }
}