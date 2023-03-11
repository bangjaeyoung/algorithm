package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Sol_86971 {
    int[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = n;

        // 1. 그래프 생성
        graph = new int[n + 1][n + 1];

        // 2. 인자로 받은 wires에 해당하는 간선들을 연결
        for (int[] wire : wires) {
            int from = wire[0], to = wire[1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int[] wire : wires) {
            int from = wire[0], to = wire[1];

            // 3. 간선을 하나씩 끊음
            graph[from][to] = 0;
            graph[to][from] = 0;

            // 4. BFS(너비 우선 탐색)로 나온 결과값과 비교하여 answer 값 갱신
            answer = Math.min(answer, bfs(n, from));

            // 5. 간선을 다시 이어줌
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        return answer;
    }

    public int bfs(int n, int from) {
        // 1. 방문을 체크할 배열 생성
        boolean[] visited = new boolean[n + 1];
        visited[from] = true;

        // 2. 연결된 송전탑을 넣을 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);

        // 3. 한 그룹의 송전탑의 개수를 셀 변수 선언
        int count = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            // 4. 인자로 받은 from부터 모든 송전탑으로 하나하나 간선이 있는지 파악
            for (int i = 1; i <= n; i++) {

                // 5. from으로부터의 간선이 존재하고, 방문한 적이 없다면 방문 체크 후, 큐에 추가 및 개수 하나 증가
                if (graph[temp][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }

        // 6. 끊어진 간선을 기준으로 나누어진 두 그룹의 송전탑의 개수의 차를 반환
        return Math.abs(count - (n - count));
    }
}
