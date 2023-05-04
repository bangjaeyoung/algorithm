import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String cloth = clothes[i][1];
            if (hashMap.containsKey(clothes[i][1])) {
                hashMap.put(cloth, hashMap.get(cloth)+1);
            } else {
                hashMap.put(cloth, 1);
            }
        }
        int answer = 1;
        for (String key : hashMap.keySet()) {
            answer *= (hashMap.get(key)+1);
        }
        return answer-1;
    }
}