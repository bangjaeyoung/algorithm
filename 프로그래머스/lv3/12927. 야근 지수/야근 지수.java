import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // 작업량이 큰 순서가 되도록 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        // 남은 시간이 없을 때까지, 작업량이 큰 작업만 1씩 줄임
        while (n > 0) {
            int work = pq.poll();
            if (work == 0) break;
            work--;
            n--;
            pq.offer(work);
        }
        // 야근 지수 구하기
        long answer = 0;
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}