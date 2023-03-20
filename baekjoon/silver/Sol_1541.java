package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        String[] split = expression.split("-");

        int answer = 0;
        for (int i = 0; i < split.length; i++) {
            int sum = 0;
            String[] tmp = split[i].split("\\+");

            for (String t : tmp) {
                sum += Integer.parseInt(t);
            }

            if (i == 0) answer += sum;
            else answer -= sum;
        }

        System.out.println(answer);
    }
}
