import java.io.*;
import java.util.*;

public class Main {
  static int[] arr, dy;
  static int len;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    arr = new int[n];
    len = arr.length;
    dy = new int[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    System.out.print(solution());
  }
  
  private static int solution() {
    int answer = 0;
    dy[0] = 1;
    
    for (int i = 1; i < len; i++) {
      int max = 0;
      
      for (int j = i-1; j >= 0; j--) {
        if (arr[i] > arr[j] && dy[j] > max) {
          max = dy[j];
        }
        
        dy[i] = max + 1;
        answer = Math.max(answer, dy[i]);
      }
    }
    
    return answer;
  }
}
