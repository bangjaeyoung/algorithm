package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Sol_1546 {
    public static void main(String[] args) {

        // 입력 받은 수만큼의 크기를 가진 배열을 만든다.
        // 배열을 돌면서, 배열의 요소를 하나씩 입력 받는다.
        // 배열의 요소들을 오름차순으로 정렬한다.
        // 배열을 돌면서, sum(합계)에 공식을 적용한 값을 넣는다.
        // 평균을 출력한다.

        Scanner sc = new Scanner(System.in);

        double[] gradeArr = new double[sc.nextInt()];

        for(int i = 0; i < gradeArr.length; i++) {
            gradeArr[i] = sc.nextDouble();
        }
        sc.close();

        Arrays.sort(gradeArr);
        double sum = 0;

        for (double arr : gradeArr) {
            sum += ((arr / gradeArr[gradeArr.length - 1]) * 100);
        }

        System.out.println(sum / gradeArr.length);
    }
}