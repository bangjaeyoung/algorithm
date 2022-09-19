package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1 -> 6 -> 12 -> 18 -> 24 로 증가되는 벌집의 개수를 각각 라인으로 생각
public class Sol_2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1일 경우는 제외하고 시작
        if (N == 1) {
            System.out.println(N);
        }
        else {

            int lineNum = 0;
            int sum = 1;

            while (true) {
                lineNum++;
                sum += lineNum * 6;

                if (N <= sum) {
                    break;
                }
            }
            System.out.println(lineNum + 1);
        }
    }
}
