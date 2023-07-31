import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> answer;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int n, m, v;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        answer = new ArrayList<>();
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        
        visited[v] = true;
        answer.add(v);
        dfs(v, 1);
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
        
        answer = new ArrayList<>();
        visited = new boolean[n + 1];
        System.out.println();
        
        bfs(v);
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
    
    private static void dfs(int vertex, int count) {
        if (count == n) return;
        else {
            for (int nextVertex : graph.get(vertex)) {
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    answer.add(nextVertex);
                    count++;
                    dfs(nextVertex, count);
                }
            }
        }
    }
    
    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = true;
        answer.add(vertex);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int currentVertex = queue.poll();
                
                for (int nextVertex : graph.get(currentVertex)) {
                    if (!visited[nextVertex]) {
                        visited[nextVertex] = true;
                        answer.add(nextVertex);
                        queue.offer(nextVertex);
                    }
                }
            }
        }
    }
}