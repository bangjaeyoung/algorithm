import java.io.*;
import java.util.*;

public class Main {
  public int solution(int n) {
    int answer = 0, sum = 0, lt = 1;

    for (int rt = 1; rt <= n/2+1; rt++) {
      sum += rt;

      while (sum > n) {
        sum -= lt++;
      }

      if (sum == n) answer++;
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Main main = new Main();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    System.out.print(main.solution(n));
  }
}
