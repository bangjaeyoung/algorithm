// ***** 다시 풀어봐야할 문제 *****
// ***** 코드 개선 전 *****
package programmers.level1;

import java.util.*;

public class Sol_42889 {
    public int[] solution(int N, int[] stages) {

        double[] failureRates = new double[N];

        for (int i = 0; i < failureRates.length; i++) {
            double numerator = 0;
            double denominator = 0;

            for (int stage : stages) {
                if (stage == i + 1) numerator++;
                if (stage >= i + 1) denominator++;
            }
            // N번째 스테이지까지 도달한 사람이 아무도 없는 경우
            if (numerator == 0 && denominator == 0) failureRates[i] = 0.0;
            else failureRates[i] = numerator / denominator;
        }

        Double[][] failureRatesAndStages = new Double[N][2];

        for (int i = 0; i < failureRatesAndStages.length; i++) {
            failureRatesAndStages[i][0] = failureRates[i];
            failureRatesAndStages[i][1] = (double) i + 1;
        }

        Double[] sortFailureRates = Arrays.stream(failureRates).boxed().toArray(Double[]::new);
        Arrays.sort(sortFailureRates, Comparator.reverseOrder());

        List<Integer> answer = new ArrayList<>();

        for (Double sortFailureRate : sortFailureRates) {
            for (Double[] failureRatesAndStage : failureRatesAndStages) {
                if (Objects.equals(sortFailureRate, failureRatesAndStage[0])) {
                    answer.add(failureRatesAndStage[1].intValue());
                }
            }
        }
        return answer.stream().distinct().mapToInt(i -> i).toArray();
    }
}
