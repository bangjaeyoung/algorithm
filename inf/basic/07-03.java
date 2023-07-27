import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(main.dfs(n));
    }

    private int dfs(int n) {
        if (n == 1) return 1;
        else return n * dfs(n-1);
    }
}
