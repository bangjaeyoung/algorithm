package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 몇 번째 대각선 라인인지
// 2. 그 라인에서 몇 번째인지
// 3. 순방향, 역방향 중 어느 방향인지
public class Sol_1193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int lineNum = 0;
        int sum = 0;

        // 1. 몇 번째 대각선 라인에 위치하는지
        while (true) {
            lineNum++;
            sum += lineNum;

            if (X <= sum) {
                break;
            }
        }

        // 2. 그 라인에서 몇 번째인지
        int num = X - (sum - lineNum);

        // 3. 짝수인 경우 -> 역방향, 홀수인 경우 -> 순방향
        if (lineNum % 2 == 0) {
            System.out.println((num) + "/" + (lineNum - num + 1));
        }
        else {
            System.out.println((lineNum - num + 1) + "/" + (num));
        }
    }
}
