package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i <= N; i++) {
            int sum = i;
            int tempI = i;

            while (tempI > 0) {
                sum += tempI % 10;
                tempI /= 10;
            }

            if (sum == N) {
                result = i;
                System.out.println(result);
                break;
            }
        }

        if (result == 0) System.out.println(result);
    }
}
