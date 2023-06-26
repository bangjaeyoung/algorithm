package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true) {

            String input = br.readLine();

            // 마지막을 알리는 .이 찍혔을 경우, 반복문 종료
            if (input.equals(".")) {
                break;
            }

            sb.append(isBalance(input)).append("\n");
        }

        System.out.println(sb);
    }

    static String isBalance(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            // 여는 괄호일 경우, 모두 스택에 저장
            if (c == '(' || c == '[') {
                stack.push(c);
            }

            // 닫는 괄호일 경우, ')' 와 ']' 를 구분해서 적용
            // ')' 일 경우 -> 분기가 나누어짐
            else if (c == ')') {

                // 스택이 비어있거나 스택에 들어간 최근 값이 '('인 경우
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }
                // 스택이 비어있지 않거나 스택에 들어간 최근 값이 '('인 경우
                else {
                    stack.pop();
                }
            }

            // ']' 일 경우 -> 분기가 나누어짐
            else if (c == ']') {

                // 스택이 비어있거나 스택에 들어간 최근 값이 '['인 경우
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }
                // 스택이 비어있지 않거나 스택에 들어간 최근 값이 '['인 경우
                else {
                    stack.pop();
                }
            }
        }

        // 최종 스택이 비어있지 않은 경우
        if (stack.isEmpty()) {
            return "yes";
        }
        else {
            return "no";
        }
    }
}
