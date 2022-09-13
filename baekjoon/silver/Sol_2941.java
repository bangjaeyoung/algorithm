package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol_2941 {

    public static void main(String[] args) throws IOException {

        // 각 케이스에 따라 카운트 증가
        // 같은 문자 만나면 증가 x

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // c= or c-
            if (ch == 'c' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            }
            // d- or dz=
            else if (ch == 'd' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                } else if (str.charAt(i + 1) == 'z' && i < str.length() - 2) {
                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }
            // lj or nj
            else if ((ch == 'l' || ch == 'n') && i < str.length() - 1) {
                if (str.charAt(i+1) == 'j') {
                    i++;
                }
            }
            // s= or z=
            else if ((ch == 's' || ch == 'z') && i < str.length() - 1) {
                if (str.charAt(i+1) == '=') {
                    i++;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
