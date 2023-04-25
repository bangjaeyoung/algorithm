import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        // 노드들의 방문 여부를 체크할 배열 생성
        visited = new boolean[n];
        // 노드들에 연결된 노드를 추가할 배열 리스트를 추가
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 노드들에 연결된 노드를 추가
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                int from = i;
                int to = j;
                if (computers[i][j] == 1) {
                    graph.get(from).add(to);
                    graph.get(to).add(from);
                }
            }
        }
        // 방문하지 않은 노드를 대상으로 dfs 진행, count 1 증가
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int node) {
        if (visited[node]) return;
        // 해당 노드의 방문한 걸로 바꾸기
        visited[node] = true;
        // 해당 노드에 연결된 모든 노드들을 순회하는데, 방문하지 않은 노드만 dfs 진행
        int size = graph.get(node).size();
        for (int i = 0; i < size; i++) {
            int value = graph.get(node).get(i);
            if (!visited[value]) {
                dfs(value);
            }
        }
    }
}