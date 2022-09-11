package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1157 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();

        int[] arr = new int[26];        // 알파벳의 개수


        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 65;       // 아스키 코드표에서 대문자와 10진수 차이는 65
            arr[num]++;
        }

        int max = -1;       // 배열 요소값이 0일 수도 있기 때문
        char result = '?';

        for (int i = 0; i < arr.length; i++) {

            if (max < arr[i]) {
                max = arr[i];
                result = (char)(i +65);
            }
            else if (max == arr[i]) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}
