package programmers.level1;

import java.util.*;

public class Sol_42576 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> nameCheck = new HashMap<>();
        String answer = "";

        for (String part : participant) {
            if (nameCheck.containsKey(part)) {
                nameCheck.put(part, nameCheck.get(part) + 1);
            } else {
                nameCheck.put(part, 1);
            }
        }
        for (String com : completion) {
            nameCheck.put(com, nameCheck.get(com) - 1);
        }
        for (String key : nameCheck.keySet()) {
            if (nameCheck.get(key) == 1) answer = key;
        }
        return answer;
    }
}
