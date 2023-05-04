import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{arr[0]};
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == stack.peek()) continue;
            else stack.push(arr[i]);
        }
        int[] answer = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}