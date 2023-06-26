package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/*
1. Truck 클래스 생성 - 무게와 이동 횟수를 필드 변수로 둠
2. 대기 중인 트럭을 담을 큐를 생성하고 담음
3. 대기 중인 트럭이 담긴 큐와 이동 중인 트럭이 담긴 큐가 함께 비어있을 때까지 반복, 한 번 반복할 때마다 카운트해줌
3-1. 이동 중인 트럭이 없을 경우에는, 대기 중인 트럭을 꺼내서 담고 현재 무게를 증가시킴
3-2. 이동 중인 트럭들을 한 칸씩 이동시킴
3-3. 이동 중인 트럭이 다리의 길이보다 더 이동했을 경우, 다리에서 내리도록 해주고 현재 무게를 감소시킴
3-4. 현재 무게와 대기 중인 트럭의 무게가 한계치보다 작거나 같을 경우, 이동 중으로 바꿔주고 현재 무게를 증가시킴
4. 카운트된 횟수를 정답으로 반환
 */
public class Sol_42583 {
     class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitingQueue = new LinkedList<>();
        Queue<Truck> movingQueue = new LinkedList<>();

        for (int t : truckWeights) {
            waitingQueue.offer(new Truck(t));
        }

        int answer = 0;
        int currentWeight = 0;

        while (!waitingQueue.isEmpty() || !movingQueue.isEmpty()) {
            answer++;

            if (movingQueue.isEmpty()) {
                Truck t = waitingQueue.poll();
                currentWeight += t.weight;
                movingQueue.offer(t);
                continue;
            }

            for (Truck t : movingQueue) {
                t.moving();
            }

            if (!movingQueue.isEmpty() && movingQueue.peek().move > bridgeLength) {
                Truck t = movingQueue.poll();
                currentWeight -= t.weight;
            }

            if (!waitingQueue.isEmpty() && currentWeight + waitingQueue.peek().weight <= weight) {
                Truck t = waitingQueue.poll();
                currentWeight += t.weight;
                movingQueue.offer(t);
            }
        }

        return answer;
    }
}
