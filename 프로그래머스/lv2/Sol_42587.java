package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 인자로 받는 우선 순위를 담은 배열을 큐의 형태로 바꾼다.
 * 2. 큐 안의 요소들에 대한 각자의 위치를 표시할 index에 대한 큐를 생성한다.
 * 3. 문제 설명대로, 큐에서 요소를 꺼내서 뒤의 요소들보다 우선 순위가 큰지 확인한다.
 *    큐의 요소들 중 가장 큰 요소는 몇인지 먼저 구한다.
 * 3. 큐에서 꺼낸 요소가 가장 큰 요소와 값이 같을 경우, 꺼내고 꺼낸 횟수를 1 증가시킨다.
 *    여기서, 꺼낸 요소의 위치 값과 인자로 받는 location 값이 동일하다면 순회를 멈춘다.
 *    큐에서 꺼낸 요소가 가장 큰 요소보다 작을 경우, 큐에 그 값을 다시 저장한 후, 꺼낸다. (맨 뒤에 다시 붙이는 것)
 *    꺼내거나 저장할 때는 항상 우선 순위에 대한 큐의 요소들과 그 요소들에 대한 index 큐의 요소들을 함께 꺼내고 저장한다.
 **/

public class Sol_42587 {
    public int solution(int[] priorities, int location) {
        Queue<Integer> prioritiesQueue = makePrioritiesQueue(priorities);
        Queue<Integer> indexQueue = makeIndexQueue(priorities.length);

        return calculateWhenCopied(prioritiesQueue, indexQueue, location);
    }

    private Queue<Integer> makePrioritiesQueue(int[] priorities) {
        Queue<Integer> prioritiesQueue = new LinkedList<>();

        for (int priority : priorities) prioritiesQueue.add(priority);

        return prioritiesQueue;
    }

    private Queue<Integer> makeIndexQueue(int prioritiesLength) {
        Queue<Integer> indexQueue = new LinkedList<>();

        for (int i = 0; i < prioritiesLength; i++) indexQueue.add(i);

        return indexQueue;
    }

    private int calculateWhenCopied(Queue<Integer> prioritiesQueue, Queue<Integer> indexQueue, int location) {
        int count = 0;

        while (true) {
            int currentCopy = prioritiesQueue.peek();
            int currentIndex = indexQueue.peek();
            int highestPriority = prioritiesQueue.stream().mapToInt(el -> el).max().getAsInt();

            if (currentCopy == highestPriority) {
                prioritiesQueue.poll();
                indexQueue.poll();
                count++;

                if (currentIndex == location) break;
            } else {
                prioritiesQueue.add(currentCopy);
                prioritiesQueue.poll();
                indexQueue.add(currentIndex);
                indexQueue.poll();
            }
        }

        return count;
    }
}
