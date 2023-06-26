package programmers.level2;

import java.util.Stack;

public class Sol_42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer[]> indicesAndPrices = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices.length - 1 - i;
            Integer[] indexAndPrice = {i, prices[i]};

            while (!indicesAndPrices.isEmpty() && indicesAndPrices.peek()[1] > prices[i]) {
                Integer beforeIndex = indicesAndPrices.pop()[0];
                answer[beforeIndex] = i - beforeIndex;
            }

            indicesAndPrices.push(indexAndPrice);
        }

        return answer;
    }
}
