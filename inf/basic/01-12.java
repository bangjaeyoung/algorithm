import java.io.*;

public class Main {
    public String solution(int a, String str) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < a; i++) {
            String substring = str.substring(i*7, (i+1)*7);

            String replace = substring
                    .replace('#', '1')
                    .replace('*', '0');

            int parseInt = Integer.parseInt(replace, 2);

            char c = (char) parseInt;

            answer.append(c);
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();

        System.out.println(main.solution(a, b));
    }
}
