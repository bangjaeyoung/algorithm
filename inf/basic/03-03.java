import java.io.*;
import java.util.*;

public class Main {
  private int solution(int n, int m, int[] arr) {
    int answer = 0, sum = 0;
    
    for (int i = 0;  i < m; i++) sum += arr[i];
    answer = sum;
    
    for (int i = m; i < n; i++) {
      sum += (arr[i] - arr[i-m]);
      answer = Math.max(answer, sum);
    }
    
    return answer;
  }
  
  public static void main(String[] args) throws IOException {
    Main main = new Main();
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    System.out.print(main.solution(n, m, arr));
  }
}
