package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// '(' 와 ')' 가 대칭적으로 같은 개수를 가질 때, "YES" 출력, 아닐 경우, "NO" 출력
// 1. '(' 일 경우, 스택에 넣고, ')' 일 경우, 스택에서 제거
// 2. 최종 스택의 결과가 비어있을 경우, "YES" 출력, 아닐 경우, "NO" 출력

public class Sol_9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            sb.append(solve(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    // VPS 여부를 판단해주는 메서드
    static String solve(String testCase) {

        Stack<String> parenthesisStack = new Stack<>();

        for (int i = 0; i < testCase.length(); i++) {

            char parenthesis = testCase.charAt(i);

            // 여는 괄호일 경우, 스택에 마지막에 '(' 추가
            if (parenthesis == '(') {
                parenthesisStack.push(String.valueOf(parenthesis));
            }

            // 닫는 괄호일 경우,
            else if (parenthesis == ')') {

                // 닫는 괄호인데, 스택이 비어있을 경우, "NO" 출력
                if (parenthesisStack.isEmpty()) {
                    return "NO";
                }
                // 닫는 괄호인데, 스택이 비어있지 않을 경우, 스택에서 마지막 '(' 제거
                else {
                    parenthesisStack.pop();
                }
            }
        }
        // 반복문을 끝내고, 스택이 비어있을 경우, "YES" 출력
        if (parenthesisStack.isEmpty()) {
            return "YES";
        }
        // 반복문을 끝내고, 스택에 '('이 남아있을 경우, "NO" 출력
        else {
            return "NO";
        }
    }
}
