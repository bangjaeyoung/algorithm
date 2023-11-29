import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int HOUR = 24, MINUTE = 60;
    static int H, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        System.out.println(solve());
    }
    
    private static String solve() {
        StringBuilder sb = new StringBuilder();
        int totalMinute = H * MINUTE + M;
        
        if (totalMinute == 45) return "0 0";
        
        if (totalMinute < 45) {
            sb.append(HOUR - 1).append(" ").append(MINUTE - (45 - M));
            return sb.toString();
        }
        
        int hour = (totalMinute - 45) / MINUTE;
        int minute = (totalMinute - 45) % MINUTE;
        
        sb.append(hour).append(" ").append(minute);
        
        return sb.toString();
    }
}
