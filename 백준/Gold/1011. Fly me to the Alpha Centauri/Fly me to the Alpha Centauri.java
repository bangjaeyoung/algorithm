import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int x, y, dis, max;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            dis = y - x;

            max = (int) Math.sqrt(dis);

            if (max == Math.sqrt(dis)) {
                sb.append(max * 2 - 1);
            }
            else if (dis <= max * max + max) {
                sb.append(max * 2);
            }
            else {
                sb.append(max * 2 + 1);
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
