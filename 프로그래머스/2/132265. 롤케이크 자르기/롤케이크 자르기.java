import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int toppingLength = topping.length;
        
        Set<Integer> front = new HashSet<>();
        Map<Integer, Integer> back = new HashMap<>();
        
        front.add(topping[0]);
        for (int i = 1; i < toppingLength; i++) {
            back.put(topping[i], back.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 1; i < toppingLength; i++) {
            front.add(topping[i]);
            back.put(topping[i], back.get(topping[i]) - 1);
            if (back.get(topping[i]) == 0) {
                back.remove(topping[i]);
            }
            
            if (front.size() == back.size()) answer++;
        }
        
        return answer;
    }
}
