package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_2675 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수 입력
        int testCase = Integer.parseInt(br.readLine());

        // 각 테스트 케이스에 들어갈 반복 수와 문자열 입력
        for (int i = 0; i < testCase; i++) {

            String[] str = br.readLine().split(" ");

            int repeat = Integer.parseInt(str[0]);

            // 반복 수만큼 문자열 각각 반복
            for (byte a : str[1].getBytes()) {
                for (int j = 0; j < repeat; j++) {
                    sb.append((char)a);
                }
            }
            sb.append("\n");
        }
        // 테스트 케이스 전체 출력
        System.out.println(sb);
    }
}
