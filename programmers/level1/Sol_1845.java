package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Sol_1845 {
    public int solution(int[] nums) {

        Map<Integer, Integer> numsHashMap = new HashMap<>();

        for (int num : nums) {
            numsHashMap.put(num, 1);
        }

        return numsHashMap.size();
    }
}
