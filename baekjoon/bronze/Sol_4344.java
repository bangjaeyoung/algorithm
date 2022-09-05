package baekjoon.bronze;

import java.util.Scanner;

public class Sol_4344 {
    public static void main(String[] args) {
        // 테스트 케이스의 개수 입력
        // 각 테스트 케이스마다 학생 수 입력
        // 학생 수 만큼 점수 입력
        // 각 테스트 케이스마다 평균
        // 각 테스트 케이스마다 평균보다 높은 점수인 학생들의 비율을 반올림해서 소수점 셋째짜리까지 출력

        Scanner in = new Scanner(System.in);

        // 학생 점수 배열
        int[] arr;

        int testCase = in.nextInt();

        for (int i = 0; i < testCase; i++) {

            // 학생 수 N
            int N = in.nextInt();
            arr = new int[N];

            // 성적 누적 합 sum
            double sum = 0;

            // 학생 점수들 입력
            for (int j = 0; j < N; j++) {
                arr[j] = in.nextInt();
                sum += arr[j];
            }

            // 평균 avg
            double avg = (sum / N);
            // 평균보다 높은 학생 수 cnt
            double cnt = 0;

            // 평균보다 높은 학생 수 카운트
            for (int j = 0; j < N; j++) {

                if (arr[j] > avg) {
                    cnt++;
                }
            }

            System.out.println(String.format("%.3f%%", (cnt / arr.length) * 100));
        }
        in.close();
    }
}