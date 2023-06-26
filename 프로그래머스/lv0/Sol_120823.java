package 프로그래머스.lv0;

import java.io.*;

public class Sol_120823 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("*".repeat(i));
        }
    }
}
