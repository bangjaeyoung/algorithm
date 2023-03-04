package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
1. jobs 배열을 작업이 시작되는 시점이 작은 수부터 오름차순 정렬
2. 배열의 두 번째 요소(작업이 걸리는 시간)를 오름차순 정렬하도록 우선 순위 큐를 생성
3. 반복문을 돌면서 작업을 하나씩 처리
3-1. 정렬된 jobs 배열의 첫 번째 요소부터 우선 순위 큐에 추가
3-2. 하나씩 꺼내면서 totalTime을 갱신하고, 다른 변수들도 같이 갱신하며 작업을 처리
4. 최종으로 구해진 totalTime을 정답으로 반환
 */
public class Sol_42627 {
    public int solution(int[][] jobs) {
        int totalTime = 0;
        int endTime = 0;
        int job = 0;
        int count = 0;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        Queue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        while (count < jobs.length) {
            while (job < jobs.length && jobs[job][0] <= endTime) {
                priorityQueue.add(jobs[job++]);
            }

            if (priorityQueue.isEmpty()) {
                endTime = jobs[job][0];
            } else {
                int[] temp = priorityQueue.poll();
                totalTime += temp[1] + endTime - temp[0];
                endTime += temp[1];
                count++;
            }
        }

        return totalTime / jobs.length;
    }
}
