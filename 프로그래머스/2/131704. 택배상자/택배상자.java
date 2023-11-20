import java.util.*;

class Solution {
    public int solution(int[] order) {
        int len = order.length;
        int answer = 0, index = 0;
        Stack<Integer> sub = new Stack<>();
        
        for (int i = 1; i <= len; i++) {
            if (order[index] != i) {
                sub.push(i);
            } else {
                index++;
                answer++;
            }
            
            while (!sub.isEmpty() && sub.peek() == order[index]) {
                sub.pop();
                index++;
                answer++;
            }
        }
        
        return answer;
    }
}
