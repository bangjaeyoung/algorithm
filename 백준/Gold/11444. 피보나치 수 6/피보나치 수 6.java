import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 입력 값이 매우 큰 피보나치 수열 구하기
 * 행렬 제곱 분할정복, 행렬 곱셈 이용
 */
public class Main {
    static final long MOD = 1_000_000_007;
    static final long[][] origin = {{1, 1}, {1, 0}}; // 초기 행렬
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long[][] a = {{1, 1}, {1, 0}};
        long n = Long.parseLong(br.readLine());
        
        System.out.println(pow(a, n - 1)[0][0]);
    }
    
    // 행렬 제곱의 분할정복 메서드
    private static long[][] pow(long[][] a, long exp) {
        if (exp == 0 || exp == 1) {
            return a;
        }
        
        long[][] ret = pow(a, exp / 2);
        
        ret = multiply(ret, ret);
        
        if (exp % 2 == 1L) {
            ret = multiply(ret, origin);
        }
        
        return ret;
    }
    
    // 두 행렬의 곱셈 메서드
    private static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];
        
        ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;
        
        return ret;
    }
}
