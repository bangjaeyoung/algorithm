import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int tLen = targets.length;
        int[] answer = new int[tLen];
        
        Map<Character, Integer> indexMap = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char k = key.charAt(i);
                if (indexMap.containsKey(k)) {
                    indexMap.put(k, Math.min(indexMap.get(k), i + 1));
                } else {
                    indexMap.put(k, i + 1);
                }
            }
        }
        
        for (int i = 0; i < tLen; i++) {
            int count = 0;
            boolean flag = true;
            for (char c : targets[i].toCharArray()) {
                if (indexMap.containsKey(c)) {
                    count += indexMap.get(c);
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer[i] = count;
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}
