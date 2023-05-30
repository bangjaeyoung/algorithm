import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
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
        
        visited[node] = true;
        int size = graph.get(node).size();
        for (int i = 0; i < size; i++) {
            int value = graph.get(node).get(i);
            if (!visited[value]) {
                dfs(value);
            }
        }
    }
}