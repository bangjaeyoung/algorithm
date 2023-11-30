import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, B;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        int[][] land = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(solve(land));
    }
    
    private static String solve(int[][] land) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] < min) {
                    min = land[i][j];
                }
                
                if (land[i][j] > max) {
                    max = land[i][j];
                }
            }
        }
        
        int minTime = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        for (int i = min; i <= max; i++) {
            int time = 0;
            int block = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (i < land[j][k]) {
                        block += (land[j][k] - i);
                        time += 2 * (land[j][k] - i);
                    }
                    
                    if (i > land[j][k]) {
                        block -= (i - land[j][k]);
                        time += (i - land[j][k]);
                    }
                }
            }
            
            if (block < 0) break;
            
            if (minTime >= time) {
                minTime = time;
                maxHeight = i;
            }
        }
        
        return minTime + " " + maxHeight;
    }
}
