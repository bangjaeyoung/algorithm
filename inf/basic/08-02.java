import java.util.Scanner;

public class Main {
    static int c, n, answer = Integer.MIN_VALUE;
    static int[] arr;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        c = in.nextInt();
        n = in.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        dfs(0, 0);
        System.out.print(answer);
    }

    private static void dfs(int level, int sum) {
        if (sum > c) return;

        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level + 1, sum + arr[level]);
            dfs(level + 1, sum);
        }
    }
}
