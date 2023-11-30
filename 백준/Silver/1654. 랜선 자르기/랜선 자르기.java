import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        max++;
        
        System.out.println(solve(N, arr, max));
    }
    
    private static long solve(int N, int[] arr, long max) {
        long min = 0;
        long mid = 0;
        
        while (min < max) {
            mid = (max + min) / 2;
            
            long count = 0;
            for (int len : arr) {
                count += (len / mid);
            }
            
            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        return min - 1;
    }
}
