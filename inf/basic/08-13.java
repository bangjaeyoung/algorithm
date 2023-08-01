import java.io.*;
import java.util.*;

public class Main {
  static int n, answer = 0;
  static int[][] islands;
  static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
  static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    
    islands = new int[n][n];
    StringTokenizer st;
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        islands[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (islands[i][j] == 1) {
          answer++;
          islands[i][j] = 0;
          dfs(i, j);
        }
      }
    }
    
    System.out.print(answer);
  }
  
  private static void dfs(int x, int y) {
    for (int i = 0; i < 8; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];
      
      if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
        if (islands[nextX][nextY] == 1) {
          islands[nextX][nextY] = 0;
          dfs(nextX, nextY);
        }
      }
    }
  }
}
