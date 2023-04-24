import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // Map에 want 목록 추가
        Map<String, Integer> wish = new HashMap<>();
        // 원래 Map으로 초기화 해주는 데 사용
        Map<String, Integer> copy = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wish.put(want[i], number[i]);
            copy.put(want[i], number[i]);
        }
        // discount 순회하면서, 가능 날짜 세기
        int count = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            // 원래 Map으로 초기화
            wish.putAll(copy);
            for (int j = i; j < i+10; j++) {
                String todayItem = discount[j];
                if (wish.containsKey(todayItem)) {
                    wish.put(todayItem, wish.get(todayItem)-1);
                }
            }
            if (check(wish)) count++;
        }
        return count;
    }
    
    // 모든 want 목록들을 구매할 수 있는지 체크
    private boolean check(Map<String, Integer> map) {
        Iterator<String> keys = map.keySet().iterator();
        boolean flag = true;
        while (keys.hasNext()) {
            String key = keys.next();
            if (map.get(key) > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}