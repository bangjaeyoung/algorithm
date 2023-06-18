import java.util.Scanner;

public class Main {
    public String solution(String str) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (str.indexOf(c) == i) {
                answer.append(c);
            }
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        Main main = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(main.solution(str));
    }
}
