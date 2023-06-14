import java.util.Scanner;

public class Main {
    public String solution(String str) {
        String[] strArr = str.split(" ");
        int len = Integer.MIN_VALUE;
        String answer = "";

        for (String st : strArr) {
            int stLen = st.length();
            if (len < stLen) {
                len = stLen;
                answer = st;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(main.solution(str));
    }
}
