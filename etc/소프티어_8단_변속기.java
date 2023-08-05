import java.util.*;
import java.io.*;

public class Main {
    static int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
    static int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] level = new int[8];

        for (int i = 0; i < 8; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        if (solution(level, ascending)) {
            System.out.print("ascending");
        } else if (solution(level, descending)) {
            System.out.print("descending");
        } else {
            System.out.print("mixed");
        }
    }

    private static boolean solution(int[] level, int[] sorting) {
        for (int i = 0; i < 8; i++) {
            if (level[i] != sorting[i]) {
                return false;
            }
        }
        
        return true;
    }
}
