import java.io.*;
import java.util.*;

class Problem {
  int score, time;
  
  public Problem(int score, int time) {
    this.score = score;
    this.time = time;
  }
}

public class Main {
  static int n, m;
  static int[] dy;
  static List<Problem> problems = new ArrayList<>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    dy = new int[m+1];
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      
      int score = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      
      problems.add(new Problem(score, time));
    }
    
    System.out.print(solution());
  }
  
  private static int solution() {
    for (int i = 0; i < n; i++) {
      Problem problem = problems.get(i);
      int score = problem.score;
      int time = problem.time;
      
      for (int j = m; j >= time; j--) {
        dy[j] = Math.max(dy[j], dy[j-time]+score);
      }
    }
    
    return dy[m];
  }
}
