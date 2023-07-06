import java.util.*;

public class Main {
    public int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int pop1 = stack.pop();
                int pop2 = stack.pop();
                switch (c) {
                    case '+':
                        sum = pop2 + pop1;
                        break;
                    case '-':
                        sum = pop2 - pop1;
                        break;
                    case '*':
                        sum = pop2 * pop1;
                        break;
                    case '/':
                        sum = pop2 / pop1;
                        break;
                }
                stack.push(sum);
            }
        }
        return stack.get(0);
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(main.solution(str));
    }
}
