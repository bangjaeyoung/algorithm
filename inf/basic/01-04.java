import java.io.*;

public class Main {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder(str).reverse();

        return String.valueOf(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            sb.append(main.solution(str)).append("\n");
        }

        System.out.print(sb);
    }
}
