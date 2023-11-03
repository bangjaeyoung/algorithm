import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int K = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());

      System.out.println(getFinalVirusCount(K, P, N));
    }

    private static long getFinalVirusCount(int K, int P, int N) {
      long count = K;
      for (int i = 0; i < N; i++) {
        count = (count * P) % 1_000_000_007;
      }
      return count;
    }
}
