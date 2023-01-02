package programmers.level2;

import java.util.Stack;

public class Sol_12973 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()) stack.add(s.charAt(i));
            else if (stack.peek() == s.charAt(i)) stack.pop();
            else stack.add(s.charAt(i));
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
