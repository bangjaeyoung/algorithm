import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] seq, dpLtoR, dpRtoL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        dpLtoR = new int[N];
        dpRtoL = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(max, dpLtoR[i] + dpRtoL[i] - 1);
        
        System.out.println(max);
    }

    private static void LIS() {
        for (int i = 0; i < N; i++) {
            dpLtoR[i] = 1;

            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j] && dpLtoR[i] < dpLtoR[j] + 1) {
                    dpLtoR[i] = dpLtoR[j] + 1;
                }
            }
        }
    }

    private static void LDS() {
        for (int i = N - 1; i >= 0; i--) {
            dpRtoL[i] = 1;

            for (int j = N - 1; j > i; j--) {
                if (seq[i] > seq[j] && dpRtoL[i] < dpRtoL[j] + 1) {
                    dpRtoL[i] = dpRtoL[j] + 1;
                }
            }
        }
    }
}
