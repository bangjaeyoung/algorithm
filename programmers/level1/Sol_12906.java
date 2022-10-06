package programmers.level1;

import java.util.*;

// 배열의 연속적인 중복된 숫자를 제거한 배열을 반환하라.
// 1. 스택을 생성하고, 스택 첫 번째 요소에 배열의 첫 번째 요소를 넣는다.
// 2. 반복문을 돌면서, 스택에서 꺼낸 값이 배열의 요소와 다를 경우만, 스택에 값을 추가한다.
// 3. 반환할 새로운 배열을 생성하고, 반복문을 통해 스택의 모든 값들을 넣어주고, 그 배열을 반환한다.
public class Sol_12906 {
    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        // 스택에서 꺼낸 값과 배열의 요소가 다를 경우에만, 스택에 추가
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] result = new int[stack.size()];

        // 스택은 가장 늦게 들어온 값이 먼저 나오므로, 배열의 맨 뒤 인덱스부터 채워줌
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
