package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2908 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 a, b 구분
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        // 문자열 a, b 거꾸로 뒤집기
        StringBuilder sb = new StringBuilder(a);
        String aReverse = sb.reverse().toString();

        StringBuilder sb2 = new StringBuilder(b);
        String bReverse = sb2.reverse().toString();

        String result = "";

        if (Integer.parseInt(aReverse) > Integer.parseInt(bReverse)) {
            result = aReverse;
        }
        else {
            result = bReverse;
        }

        System.out.println(result);
    }
}
