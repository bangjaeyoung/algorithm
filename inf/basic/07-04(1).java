import java.util.*;

public class Main {
    static int[] fibo;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n + 1];
        
        main.dfs(n);
        
        for (int i = 1; i <= n; i++)
            System.out.print(fibo[i] + " ");
    }

    private int dfs(int n) {
        if (fibo[n] > 0) return fibo[n];
        
        if (n == 1 || n == 2)
            return fibo[n] = 1;
        else
            return fibo[n] = dfs(n - 2) + dfs(n - 1);
    }
}
