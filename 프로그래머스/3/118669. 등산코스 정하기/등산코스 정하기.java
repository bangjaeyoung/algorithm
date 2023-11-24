import java.util.*;

class Solution {
    private List<List<Edge>> graph;
    
    private class Edge {
        int vertex, weight;
        
        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] path : paths) {
            int start = path[0];
            int end = path[1];
            int weight = path[2];
            
            if (isGate(start, gates) || isSummit(end, summits)) {
                graph.get(start).add(new Edge(end, weight));
            } else if (isGate(end, gates) || isSummit(start, summits)) {
                graph.get(end).add(new Edge(start, weight));
            } else {
                graph.get(start).add(new Edge(end, weight));
                graph.get(end).add(new Edge(start, weight));
            }
        }
        
        return dijkstra(n, gates, summits);
    }
    
    private boolean isGate(int vertex, int[] gates) {
        for (int gate : gates) {
            if (vertex == gate) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isSummit(int vertex, int[] summits) {
        for (int summit : summits) {
            if (vertex == summit) {
                return true;
            }
        }
        
        return false;
    }
    
    private int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Edge> queue = new LinkedList<>();
        int[] intensity = new int[n + 1];
        
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        for (int gate : gates) {
            queue.offer(new Edge(gate, 0));
            intensity[gate] = 0;
        }
        
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            
            if (now.weight > intensity[now.vertex]) continue;
            
            for (int i = 0; i < graph.get(now.vertex).size(); i++) {
                Edge next = graph.get(now.vertex).get(i);
                
                int dis = Math.max(intensity[now.vertex], next.weight);
                if (intensity[next.vertex] > dis) {
                    intensity[next.vertex] = dis;
                    queue.offer(new Edge(next.vertex, dis));
                }
            }
        }
            
        int maxSummit = Integer.MAX_VALUE;
        int maxWeight = Integer.MAX_VALUE;
            
        Arrays.sort(summits);
            
        for (int summit : summits) {
            if (intensity[summit] < maxWeight) {
                maxSummit = summit;
                maxWeight = intensity[summit];
            }
        }
            
        return new int[]{maxSummit, maxWeight};
    }
}
