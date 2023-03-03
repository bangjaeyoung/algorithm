package programmers.level2;

import java.util.PriorityQueue;
import java.util.Queue;

/*
1. 우선 순위 큐 생성
2. 스코빌 지수를 우선 순위 큐에 하나씩 담기 - 자동 정렬
3. 우선 순위 큐에서 하나를 꺼낸 값이 k보다 작으면 계속 반복
3-1. 만약, 두 스코빌 지수를 섞어서 나온 값이 k보다 작고 유일한 값일 경우, -1 반환
3-2. 우선 순위 큐에서 하나를 꺼낸 값은 제일 작은 스코빌 지수의 값
3-3. 두 개를 꺼내서 섞고, 우선 순위 큐에 다시 담기 - 자동 정렬
4. 반복문을 한 번 돌 때마다 answer 값을 1씩 증가시키고 최종 answer을 정답으로 반환
 */
public class Sol_42626 {
    public int solution(int[] scoville, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        for (int s : scoville) {
            priorityQueue.offer(s);
        }

        int answer = 0;

        while (priorityQueue.peek() < k) {
            if (priorityQueue.size() == 1) return -1;

            int first = priorityQueue.poll();
            int second = priorityQueue.poll();

            int mix = first + (second * 2);
            priorityQueue.offer(mix);
            answer++;
        }

        return answer;
    }
}
