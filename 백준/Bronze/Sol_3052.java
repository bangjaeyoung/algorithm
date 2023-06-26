package baekjoon.bronze;

import java.util.Scanner;

public class Sol_3052 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // boolean 타입의 크기가 42인 배열을 만든다.
        // 입력받은 수를 42로 나눈 나머지가 인덱스가 되고, 인덱스의 값을 true로 바꾸어준다.
        // 배열을 돌면서, true의 개수를 구하고 출력한다.

        boolean[] arr = new boolean[42];
        int index;
        int count = 0;

        for(int i = 0; i < 10; i++) {
            index = input.nextInt() % 42;
            arr[index] = true;
        }

        for(boolean ar : arr) {
            if(ar) count++;
        }

        System.out.println(count);
    }
}
