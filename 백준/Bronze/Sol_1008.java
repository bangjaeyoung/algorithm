package baekjoon.bronze;

import java.util.Scanner;

public class Sol_1008 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        System.out.println(A / B);
        System.out.println(A % B);
    }
}