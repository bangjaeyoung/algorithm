import java.io.*;
import java.util.*;

/**
 * Dynamic Programming - 0/1 Knapsack Problem
 */
class Stuff {
    int weight, value;

    public Stuff(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Stuff> stuffs = new ArrayList<>();
        dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            stuffs.add(new Stuff(weight, value));
        }

        System.out.print(solution(stuffs, K));
    }

    private static int solution(List<Stuff> stuffs, int limit) {
        for (Stuff stuff : stuffs) {
            for (int i = limit; i >= stuff.weight; i--) {
                dp[i] = Math.max(dp[i], dp[i - stuff.weight] + stuff.value);
            }
        }

        return dp[limit];
    }
}
