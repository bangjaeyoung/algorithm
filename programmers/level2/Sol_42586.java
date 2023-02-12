package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 1. 작업 진도가 100일 때, 배포가 가능하다. 먼저, 남은 작업 진도에서 각 작업 속도로 얼마나 남았는지 계산한다.
 * 배포까지 걸리는 시간 = (100 - 현재 작업 진도) / 작업 속도
 * 2. 각 작업들을 배포하기까지 걸리는 시간들을 큐에 집어 넣는다.
 * 3. 첫 작업의 배포까지의 시간이 뒤의 시간들보다 클 경우, 첫 작업이 배포될 때 뒤의 작업들까지 같이 큐에서 빠져나간다.
 * 4. 함께 빠져나간 작업들의 개수를 결과 배열리스트에 저장한다.
 * 5. 3,4 과정을 반복하면서 최종적으로 나온 결과 배열리스트를 배열로 변환한다.
 */
public class Sol_42586 {
    private Queue<Integer> getRemainingTasks(int[] progresses, int[] speeds) {
        Queue<Integer> remainingTasks = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainingTask = 100 - progresses[i];

            if ((remainingTask) % speeds[i] > 0) remainingTasks.add(remainingTask / speeds[i] + 1);
            else remainingTasks.add(remainingTask / speeds[i]);
        }

        return remainingTasks;
    }

    private List<Integer> getCountsOfDeployTasks(Queue<Integer> remainingTasks) {
        List<Integer> answer = new ArrayList<>();
        int deployDay;
        int originalSize = remainingTasks.size();

        while (remainingTasks.size() > 0) {
            deployDay = remainingTasks.peek();

            while (deployDay >= remainingTasks.peek()) {
                remainingTasks.poll();

                if (remainingTasks.size() == 0) break;
            }
            answer.add(originalSize - remainingTasks.size());
            originalSize = remainingTasks.size();
        }

        return answer;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        if (progresses.length == 0) return new int[]{0};

        List<Integer> answer = getCountsOfDeployTasks(getRemainingTasks(progresses, speeds));

        return answer.stream().mapToInt(el -> el).toArray();
    }
}
