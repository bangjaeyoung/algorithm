import java.io.*;
import java.util.*;

public class Main {
    static List<Long> decreasingNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        decreasingNums = new LinkedList<>();

        makeDecreasingNums();
        Collections.sort(decreasingNums);

        if (N <= 10) 
            System.out.println(N);
        else if (N > 1022) 
            System.out.println(-1);
        else 
            System.out.println(decreasingNums.get(N));
    }

    private static void makeDecreasingNums() {
        for (int i = 0; i < 10; i++) {
            dfs(i, 1);
        }
    }

    private static void dfs(long n, int idx) {
        if (idx > 10) return;

        decreasingNums.add(n);

        for (int i = 0; i < n % 10; i++) {
            dfs(n * 10 + i, idx + 1);
        }
    }
}
