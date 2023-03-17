package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 투 포인터 알고리즘
public class Sol_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 1;
        int count = 1;  // 자기 자신
        int startIdx = 1;
        int endIdx = 1;

        while (endIdx != N) {
            if (sum == N) {
                count++;
                endIdx++;
                sum += endIdx;
            } else if (sum > N) {
                sum -= startIdx;
                startIdx++;
            } else {
                endIdx++;
                sum += endIdx;
            }
        }

        System.out.println(count);
    }
}
