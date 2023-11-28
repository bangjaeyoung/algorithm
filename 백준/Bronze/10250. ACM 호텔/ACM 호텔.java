import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, H, W, N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());    // 케이스 개수
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());   // 층수(세로 길이)
            W = Integer.parseInt(st.nextToken());   // 호수(가로 길이)
            N = Integer.parseInt(st.nextToken());   // 타겟 사람
            
            result.append(solve()).append("\n");
        }
        
        System.out.println(result);
    }
    
    private static String solve() {
        StringBuilder sb = new StringBuilder();
        
        int roomH = (N % H == 0) ? H : (N % H);
        int roomW = (N % H == 0) ? (N / H) : (N / H + 1);
        
        sb.append(roomH);
        if (roomW < 10) {
            sb.append("0");
        }
        sb.append(roomW);
        
        return sb.toString();
    }
}
