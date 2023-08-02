import java.util.*;
  
public class Main {
  static int[] coins, dy;
  static int n, m;
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    
    coins = new int[n+1];
    for (int i = 1; i <= n; i++) {
      coins[i] = sc.nextInt();
    }
    
    m = sc.nextInt();
    dy = new int[m+1];
    
    System.out.print(solution());
  }
  
  private static int solution() {
    Arrays.fill(dy, Integer.MAX_VALUE);
    dy[0] = 0;
    
    for (int i = 1; i <= n; i++) {
      for (int j = coins[i]; j <= m; j++) {
        dy[j] = Math.min(dy[j], dy[j-coins[i]]+1);
      }
    }
    
    return dy[m];
  }
}
