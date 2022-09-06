package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1065 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        System.out.println(cnt(input));
    }

    public static int cnt(int input) {

        int cnt = 0;    // 한수 카운팅 변수 선언 및 초기화

        if (input < 100) {              // 100 미만의 수는 모두 한수이므로, 그대로 input 리턴
            return input;
        }

        else {

            cnt = 99;

            for (int i = 100; i <= input; i++) {
                int hun = i / 100;  // 백의 자리
                int ten = (i / 10) % 10;    //십의 자리
                int one = i % 10;   // 일의 자리

                if ((hun - ten) == (ten - one)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}