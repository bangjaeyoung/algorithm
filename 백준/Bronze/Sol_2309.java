package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarfs = new int[9];
        int totalHeight = 0;

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            totalHeight += dwarfs[i];
        }

        Arrays.sort(dwarfs);

        outLoop :
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (totalHeight - dwarfs[i] - dwarfs[j] == 100) {
                    dwarfs[i] = 0;
                    dwarfs[j] = 0;
                    break outLoop;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (dwarfs[i] != 0) {
                System.out.println(dwarfs[i]);
            }
        }
    }
}
