import java.util.Scanner;

public class Main {
    static int n;
    static int[] chk;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
      
        n = sc.nextInt();
        chk = new int[n + 1];
      
        main.dfs(1);
    }

    private void dfs(int depth) {
        if (depth == n + 1) {
            for (int i = 0; i < n + 1; i++) {
                if (chk[i] == 1)
                    System.out.print(i + " ");
            }
            System.out.println();
        } else {
            chk[depth] = 1;
            dfs(depth + 1);
          
            chk[depth] = 0;
            dfs(depth + 1);
        }
    }
}
