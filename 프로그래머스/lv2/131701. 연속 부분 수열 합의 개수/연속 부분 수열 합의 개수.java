import java.util.*;

class Solution {
    public int solution(int[] elements) {
        List<Integer> sumList = new ArrayList<>();
        int length = elements.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == i + j) {
                    sumList.add(elements[i]);
                } else {
                    sumList.add(doSum(elements, i, i + j));
                }
            }
        }
        return (int) sumList.stream().distinct().count();
    }
    
    private int doSum(int[] elements, int to, int end) {
        int sum = 0;
        for (int i = to; i <= end; i++) {
            int tempIdx = i;
            if (tempIdx >= elements.length) {
                tempIdx %= elements.length;
            }
            sum += elements[tempIdx];
        }
        return sum;
    }
}