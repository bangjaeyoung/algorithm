import java.util.*;

public class Main {
  static int n, m, answer = Integer.MAX_VALUE;
  static Integer[] coins;
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    
    coins = new Integer[n];
    for (int i = 0; i < n; i++) {
      coins[i] = sc.nextInt();
    }
    Arrays.sort(coins, Collections.reverseOrder());
    
    m = sc.nextInt();

    dfs(0, 0);
    System.out.print(answer);
  }
  
  private static void dfs(int count, int sum) {
    if (count >= answer || sum > m) return;
    
    if (sum == m) {
      answer = Math.min(answer, count);
    } else {
      for (int i = 0; i < n; i++) {
        dfs(count + 1, sum + coins[i]);
      }
    }
  }
}
