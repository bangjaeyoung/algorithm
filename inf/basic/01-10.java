import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(String str, char c) {
        int[] answer = new int[str.length()];

        int distance = 100;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                distance = 0;
                answer[i] = distance;
            }
            else {
                answer[i] = ++distance;
            }
        }

        distance = 100;
        for (int i = str.length()-1; i >= 0 ; i--) {
            if (str.charAt(i) == c) {
                distance = 0;
            }
            else {
                answer[i] = Math.min(answer[i], ++distance);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        String s = st.nextToken();
        char t = st.nextToken().charAt(0);

        for (int x : main.solution(s, t)) {
            System.out.print(x + " ");
        }
    }
}
