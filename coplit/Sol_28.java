package coplit;

/*문자열을 입력받아 문자열 내의 모든 괄호의 짝이 맞는지 여부를 리턴해야 합니다.
  괄호를 제외한 문자열이 포함된 경우에도 작동하도록 합니다.
  괄호는 닫힌 괄호가 시작되면, 이후로 열린 괄호가 입력될 수 없습니다.*/
import java.util.Stack;

public class Sol_28 {
    public boolean balancedBrackets(String str) {
        // 예외 케이스
        if (str.length() == 0) return true;

        Stack<Character> bracketsStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(': case '[': case '{':
                    bracketsStack.add(str.charAt(i));
                    break;
                case ')':
                    if (bracketsStack.isEmpty()) return false;	//EmptyStackException 에러 방지
                    if (bracketsStack.pop() != (char) (str.charAt(i) - 1)) return false;  // 아스키 코드 값 '(' = ')' - 1
                    break;
                case ']': case '}':
                    if (bracketsStack.isEmpty()) return false;	//EmptyStackException 에러 방지
                    if (bracketsStack.pop() != (char) (str.charAt(i) - 2)) return false;  // 아스키 코드 값 '[', '{' = ']', '}' - 2
                    break;
            }
        }
        return bracketsStack.isEmpty();
    }
}
