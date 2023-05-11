import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> idx = new Stack<>();
        idx.push(0);
        for (int i = 1; i < numbers.length; i++) {
            while (!idx.isEmpty() && numbers[i] > numbers[idx.peek()]) {
                numbers[idx.pop()] = numbers[i];
            }
            idx.push(i);
        }
        while (!idx.isEmpty()) {
            numbers[idx.pop()] = -1;
        }
        return numbers;
    }
}