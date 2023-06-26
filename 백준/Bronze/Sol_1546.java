package baekjoon.bronze;

import java.util.Scanner;

public class Sol_1546 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        int M = 0;
        int sum = 0;
        for (int score : scores) {
            M = Math.max(M, score);
            sum += score;
        }

        System.out.print((sum * 100.0 / M) / N);
    }
}
