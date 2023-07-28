import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=1; i<=n; i++)
            System.out.print(main.dfs(i) + " ");
    }

    private int dfs(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return dfs(n-2) + dfs(n-1);
    }
}
