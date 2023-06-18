import java.util.Scanner;

public class Main {
    public String solution(String str) {
        str += " ";

        StringBuilder answer = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) != str.charAt(i+1)) {
                answer.append(str.charAt(i));

                if (cnt > 1) {
                    answer.append(cnt);
                    cnt = 1;
                }
            }
            else {
                cnt++;
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
