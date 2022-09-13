package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1316 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int cnt =  0;

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            boolean[] check = new boolean[26];      // 알파벳 개수만큼 크기인 배열 생성
            boolean groupIs = true;     // 그룹 단어인지 아닌지를 true, false로

            for (int j = 0; j < str.length(); j++) {
                int index = str.charAt(j) - 'a';

                if (check[index]) {
                    if (str.charAt(j) != str.charAt(j - 1)) {       // 이전 인덱스의 문자와 비교
                        groupIs = false;
                        break;
                    }
                }
                else {
                    check[index] = true;
                }
            }
            if (groupIs) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
