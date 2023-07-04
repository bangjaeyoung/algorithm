import java.util.*;

public class Main {
    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty())
                    return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty())
            return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(main.solution(str));
    }
}
