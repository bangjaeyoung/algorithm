package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sol_8958 {
    public static void main(String[] args) throws IOException {

        // 입력받은 수 num 만큼 크기를 가진 배열 arr을 생성
        // for문을 통해 arr에 요소를 넣음
        // for문을 통해 O를 찾으면 누적 개수 count를 증가, 증가된 누적개수를 합계 sum에 저장
        // sum 값 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        String[] arr = new String[num];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }


        for (int i = 0; i < arr.length; i++) {

            int cnt = 0;
            int sum = 0;

            for (int j = 0; j < arr[i].length(); j++) {

                if (arr[i].charAt(j) == 'O') {
                    cnt++;
                    sum += cnt;
                }
                else {
                    cnt = 0;
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
