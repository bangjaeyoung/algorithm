import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }
        for (Character s : stack) {
            answer.append(s);
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(main.solution(str));
    }
}
