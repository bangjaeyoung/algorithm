package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_10870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));
    }

    static int fibonacci(int num) {

        if (num <= 1) return num;

        return fibonacci(num - 2) + fibonacci(num - 1);
    }
}
