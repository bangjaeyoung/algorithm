import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        
        int length = elements.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length; j++) {
                int sum = 0;
                for (int k = i; k < i + j; k++) {
                    sum += elements[k % length];
                }
                answer.add(sum);
            }
        }
        return answer.size();
    }
}