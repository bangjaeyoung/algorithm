package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class Sol_42578 {
    private Map<String, Integer> countClothesByType(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] cloth : clothes) {
            if (clothesMap.containsKey(cloth[1]))
                clothesMap.put(cloth[1], clothesMap.get(cloth[1]) + 1);
            else
                clothesMap.put(cloth[1], 1);
        }

        return clothesMap;
    }

    private int countClothingCombination(Map<String, Integer> clothesMap) {
        int answer = 1;

        for (String clothesType : clothesMap.keySet())
            answer *= (clothesMap.get(clothesType) + 1);

        return answer - 1;
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = countClothesByType(clothes);

        return countClothingCombination(clothesMap);
    }
}
