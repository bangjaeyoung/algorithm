import java.io.*;
import java.util.*;

public class Main {
    public static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        
        System.out.println(pow(a, b));
    }
    
    private static long pow(long a, long exponent) {
        if (exponent == 1) return a % c;
        
        long temp = pow(a, exponent / 2);
        
        if (exponent % 2 == 1) {
            return ((temp * temp % c) * a) % c;
        } else return temp * temp % c;
    }
}