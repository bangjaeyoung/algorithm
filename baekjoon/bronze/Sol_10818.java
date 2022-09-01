package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Sol_10818 {

    public static void main(String[] args) {

        // 첫째 줄 n 입력 받기
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] arr = new int[n];

        // n 만큼의 크기인 배열에 숫자를 하나씩 입력 받기
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        // 입력 멈추고, arr 배열 오름차순
        input.close();
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[n-1]);
    }
}
