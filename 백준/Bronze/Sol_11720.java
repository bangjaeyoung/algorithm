package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_11720 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] charNum = br.readLine().toCharArray();

        int sum = 0;
        for (char ch : charNum)
            sum += ch - '0';

        System.out.print(sum);
    }
}
