package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 우선순위 큐
public class Sol_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);

            // 절댓값이 같은 경우, 음수 우선
            if (firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1;
            }

            // 절댓값이 작은 데이터 우선
            return firstAbs - secondAbs;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int operation = Integer.parseInt(br.readLine());

            if (operation == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(operation);
            }
        }

        System.out.println(sb);
    }
}
