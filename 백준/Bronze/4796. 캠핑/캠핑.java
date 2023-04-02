import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int l;
        int p;
        int v;
        int count = 1;
        StringBuilder sb;
        int result;
        int temp;

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            if (l == 0 && p == 0 && v == 0) return;

            temp = Math.min(v % p, l);
            result = l * (v / p) + temp;

            sb = new StringBuilder();
            sb.append("Case ").append(count).append(": ").append(result);
            System.out.println(sb);

            count++;
        }
    }
}