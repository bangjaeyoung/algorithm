import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> idx = new Stack<>();
        idx.push(0);
        
        for (int i = 1; i < len; i++) {
            int num = numbers[i];
            while (!idx.isEmpty() && num > numbers[idx.peek()]) {
                answer[idx.pop()] = num;
            }
            idx.push(i);
        }
        
        while (!idx.isEmpty()) {
            answer[idx.pop()] = -1;
        }
        
        return answer;
    }
}