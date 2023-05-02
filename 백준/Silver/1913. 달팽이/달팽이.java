import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] snail = new int[n][n];
        int print = n;
        int start = n * n;
        int width = -1;
        int length = 0;
        int control = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < print; j++) {
                width += control;
                snail[width][length] = start;
                start--;
            }
            print--;
            for (int j = 0; j < print; j++) {
                length += control;
                snail[width][length] = start;
                start--;
            }
            control *= -1;
        }
        
        int x = 0;
        int y = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int s = snail[i][j];
                sb.append(s).append(" ");
                if (s == m) {
                    x = i + 1;
                    y = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}