package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

// Kruskal Algorithm + Union Find
public class Sol_42861 {
    public static int[] parent;

    public int solution(int n, int[][] costs) {
        int totalCost = 0;

        // 간선의 가중치(cost) 기준으로 오름차순 정렬
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));

        // 각자 노드의 부모 노드를 자기 자신으로 설정
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] edge : costs) {
            int fromNode = edge[0];
            int toNode = edge[1];
            int cost = edge[2];

            int fromNodeParent = findParent(fromNode);
            int toNodeParent = findParent(toNode);

            // 부모 노드가 서로 같다면, 이미 연결된 것으로 보고 다음 순회로 이동
            if (fromNodeParent == toNodeParent) continue;

            // 부모 노드가 서로 다르다면, 하나의 노드의 부모 노드로 통일(두 노드를 연결)
            totalCost += cost;
            parent[toNodeParent] = fromNodeParent;
        }

        return totalCost;
    }

    // 해당 노드의 간선을 따라 올라가면서 최종 부모 노드를 찾는 과정
    private int findParent(int node) {
        if (parent[node] == node) return node;
        return findParent(parent[node]);
    }
}
