import java.util.*;

/*
1. 오름차순과 내림차순으로 정렬할 우선순위 큐를 각각 생성
2. 인자로 받은 operations 배열을 순회
2-1. 공백을 구분자로 나누고, 문제의 설명에 맞게 처리
2-2. 오름차순, 내림차순 우선순위 큐의 요소들은 동시에 추가되고 삭제
2-3. 하나가 빈 큐이면 다른 하나도 빈 큐이고, 조건에 하나의 큐만 비어있지 않는다는 조건을 달아줘도 무방
3. 최종적으로 둘 중 하나라도 빈 큐이면 [0, 0]을 답으로 반환,
3-1. 아니면 [내림차순 큐에서 꺼낸 값(최댓값), 오름차순 큐에서 꺼낸 값(최솟값)]을 반환
 */
class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> ascendingPQ = new PriorityQueue<>();
        Queue<Integer> descendingPQ = new PriorityQueue<>((o2, o1) -> o1 - o2);
        for (String operation : operations) {
            String[] temp = operation.split(" ");
            if (temp[0].equals("I")) {
                ascendingPQ.offer(Integer.parseInt(temp[1]));
                descendingPQ.offer(Integer.parseInt(temp[1]));
            } else if (temp[0].equals("D") && !ascendingPQ.isEmpty()) {
                if (temp[1].equals("-1")) {
                    descendingPQ.remove(ascendingPQ.poll());
                } else if (temp[1].equals("1")) {
                    ascendingPQ.remove(descendingPQ.poll());
                }
            }
        }
        return ascendingPQ.isEmpty() ? new int[]{0,0} : new int[]{descendingPQ.poll(), ascendingPQ.poll()};
    }
}