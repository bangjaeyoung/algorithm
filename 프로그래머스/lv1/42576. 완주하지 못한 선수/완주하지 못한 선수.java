import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (String part : participant) {
            if (hashMap.containsKey(part)) {
                hashMap.put(part, hashMap.get(part)+1);
            } else {
                hashMap.put(part, 1);
            }
        }
        for (String com : completion) {
            hashMap.put(com, hashMap.get(com)-1);
        }
        String answer = "";
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                answer = key;
            }
        }
        return answer;
    }
}