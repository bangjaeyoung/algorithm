package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Sol_10757 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // " "으로 구분자 구분
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        // 두 수 덧셈
        A = A.add(B);

        System.out.println(A.toString());
    }
}