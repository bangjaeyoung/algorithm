import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        main.dfs(n);
    }

    private void dfs(int n) {
        if (n == 0) return;

        dfs(n/2);
        System.out.print(n%2);
    }
}
