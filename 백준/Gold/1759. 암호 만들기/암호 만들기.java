import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] chArr, combi;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        combi = new char[L];
        chArr = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chArr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chArr);

        dfs(0, 0);

        System.out.print(sb);
    }

    // 암호의 조합을 만드는 메서드
    private static void dfs(int level, int start) {
        if (level == L) {
            if (checkPassword(combi)) {
                for (char c : combi) {
                    sb.append(c);
                }
                sb.append("\n");
            }
        } else {
            for (int i = start; i < C; i++) {
                combi[level] = chArr[i];
                dfs(level + 1, i + 1);
            }
        }
    }

    // 최소 모음 1개와 자음 2개가 있는 적절한 암호인지 판별하는 메서드
    private static boolean checkPassword(char[] chArr) {
        int vowelCount = 0, consonantCount = 0;

        for (char c : chArr) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }
}
