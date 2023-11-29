import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int A, B, C;
    static int[] count = new int[10];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        
        solve();
        
        StringBuilder result = new StringBuilder();
        for (int c : count) {
            result.append(c).append("\n");
        }
        
        System.out.println(result);
    }
    
    private static void solve() {
        int total = A * B * C;
        
        while (total > 0) {
            count[total % 10]++;
            total /= 10;
        }
    }
}
