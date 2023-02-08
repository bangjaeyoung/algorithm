package programmers.level2;

import java.util.Stack;

public class Sol_76502 {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            sb.insert(s.length(), sb.charAt(0));
            sb.deleteCharAt(0);

            if (checkRightParentheses(String.valueOf(sb))) answer++;
        }

        return answer;
    }

    private static boolean checkRightParentheses(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            switch (c) {
                case '[':
                case '(':
                case '{':
                    stack.push(String.valueOf(c));
                    break;

                case ')':
                    if (stack.isEmpty()) return false;

                    if (stack.peek().charAt(0) == (char) (c - 1)) {
                        stack.pop();
                        break;
                    } else return false;

                case ']':
                case '}':
                    if (stack.isEmpty()) return false;

                    if (stack.peek().charAt(0) == (char) (c - 2)) {
                        stack.pop();
                        break;
                    } else return false;
            }
        }

        return stack.isEmpty();
    }
}
