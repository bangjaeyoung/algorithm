import java.io.*;
import java.util.*;

public class Main {
    private List<Integer> solution(int n, int m, int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        
        while (p1 < n && p2 < m) {
            if (a[p1] <= b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        
        while (p1 < n) answer.add(a[p1++]);
        while (p2 < m) answer.add(b[p2++]);
        
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());
        
        for (int x : main.solution(n, m, a, b)) System.out.print(x + " ");
    }
}
