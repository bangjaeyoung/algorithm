import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        int answer = 0;
        for (int key : hashMap.keySet()) {
            answer++;
        }
        return answer > nums.length / 2 ? nums.length / 2 : answer;
    }
}