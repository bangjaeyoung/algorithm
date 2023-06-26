package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol_10809 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // 알파벳 개수만큼인 크기의 배열 생성 및 초기화
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < str.length(); i++) {

            if (arr[str.charAt(i) - 'a'] == -1) {       // 중복된 문자열일 경우, 처음 맞닥뜨린 문자열의 인덱스 값을 할당
                arr[str.charAt(i) - 'a'] = i;
            }
        }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }
}
