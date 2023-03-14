package programmers.level2;

import java.util.Stack;

public class Sol_42883 {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        // 1. 현재 문자값과 스택에서 뺀 값과 비교해서 스택에서 뺼지 말지 고려
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // 2. 현재 문자값이 더 크다면, 스택에서 뺀 값이 더 크기 전까지 요소를 빼는 작업
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            // 3. 큰 문자값(현재)을 스택에 추가
            stack.push(c);
        }

        // 4. 최종 스택의 요소들을 인덱스 순서대로 결과 배열에 저장
        for (int i = 0; i < result.length; i++)
            result[i] = stack.get(i);

        return new String(result);
    }
}
