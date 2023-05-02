import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = Math.min(n, m) / 2;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < cnt; j++) {
                int x = j;
                int y = j;
                int init = arr[j][j];
                int idx = 0;
                while (idx < 4) {
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];
                    if (nx >= j && ny >= j && nx < n-j && ny < m-j) {
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    } else idx++;
                }
                arr[j+1][j] = init;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = arr[i][j];
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}