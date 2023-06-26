package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Sol_1845 {
    public int solution(int[] nums) {

        Map<Integer, Integer> numsHashMap = new HashMap<>();

        // 중복된 폰켓몬 종류는 하나의 종류로 취급
        for (int num : nums) {
            numsHashMap.put(num, 1);
        }

        // 최대로 나올 수 있는 종류는 N / 2 마리
        return Math.min(numsHashMap.size(), nums.length / 2);
    }
}
