package baekjoon.bronze;

import java.util.Scanner;

public class Sol_2562 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // 입력 받을 9개의 수를 배열에 넣기
        int[] arr = new int[9];
        int max = 0;
        int cnt = 0;

        // 9번 순회하면서 최대값 구하고, 그 최대값의 인덱스 찾기
        for(int i = 0; i < 9; i++) {
            arr[i] = input.nextInt();

            if(arr[i] > max) {
                max = arr[i];
                cnt = i;
            }
        }

        // 최대값과 그 최대값이 몇 번째(인덱스+1)인지 출력하기
        System.out.println(max);
        System.out.println(cnt + 1);
    }
}
