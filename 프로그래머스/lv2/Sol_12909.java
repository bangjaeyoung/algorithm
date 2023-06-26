package programmers.level2;

import java.util.Stack;

public class Sol_12909 {
    boolean solution(String s) {
        Stack<Character> roundBrackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (roundBrackets.isEmpty()) return false;
                else roundBrackets.pop();
            } else roundBrackets.push(s.charAt(i));
        }

        return roundBrackets.isEmpty();
    }
}
