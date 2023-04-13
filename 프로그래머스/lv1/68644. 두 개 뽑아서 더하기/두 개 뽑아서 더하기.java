import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!answer.contains(sum)) {
                    answer.add(sum);
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer.stream().mapToInt(i -> i).toArray();
    }
}