package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.PriorityQueue;

public class Sol_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();

            answer += (num1 + num2);
            pq.offer(num1 + num2);
        }

        System.out.println(answer);
    }
}
