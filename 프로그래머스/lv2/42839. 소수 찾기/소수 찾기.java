import java.util.*;

class Solution {
    static Set<Integer> hashSet = new HashSet<>();
    
    public int solution(String numbers) {
        recursive("", numbers);
        
        int answer = 0;
        Iterator<Integer> iter = hashSet.iterator();
        while (iter.hasNext()) {
            int number = iter.next();
            if (isPrime(number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    void recursive(String combination, String others) {
        if (!combination.equals("")) {
            hashSet.add(Integer.parseInt(combination));
        }
        
        for (int i = 0; i < others.length(); i++) {
            recursive(combination + others.charAt(i),
                     others.substring(0, i) + others.substring(i + 1)
                     );
        }
    }
}