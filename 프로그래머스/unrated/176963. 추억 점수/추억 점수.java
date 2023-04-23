import java.util.*;

class Solution {
    public int[] solution(String[] names, int[] yearning, String[][] photo) {
        // 1. Map<이름, 그리움> 추가
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], yearning[i]);
        }
        // 2. photo 2차원 배열 순회하면서 그리움 총합 구하기
        int photoLen = photo.length;
        int[] answer = new int[photoLen];
        for (int i = 0; i < photoLen; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                String name = photo[i][j];
                if (map.containsKey(name)) {
                    sum += map.get(name);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}