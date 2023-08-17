import java.io.*;

public class Main {
    static int[][] dp;
    static int length_1, length_2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        length_1 = str1.length;
        length_2 = str2.length;

        dp = new int[length_1 + 1][length_2+ 1];

        System.out.print(LCS(str1, str2));
    }

    private static int LCS(char[] str1, char[] str2) {
        for (int i = 1; i <= length_1; i++) {
            for (int j = 1; j <= length_2; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[length_1][length_2];
    }
}
