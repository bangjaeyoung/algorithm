import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    public int vertex, cost;
    
    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }
}

public class Main {
    static List<List<Edge>> graph;
    static int[] distance;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        distance = new int[V+1];
        
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(from).add(new Edge(to, cost));
        }
        
        solution(K);
        
        for (int i = 1; i <= V; i++) {
            int currentDistance = distance[i];
            
            if (currentDistance != Integer.MAX_VALUE) {
                System.out.println(currentDistance);
            } else {
                System.out.println("INF");
            }
        }
    }
    
    public static void solution(int startVertex) {
        Queue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(startVertex, 0));
        distance[startVertex] = 0;
        
        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();
            int nowVertex = now.vertex;
            int nowCost = now.cost;
            
            if (nowCost > distance[nowVertex]) continue;
            
            for (Edge next : graph.get(nowVertex)) {
                int nextVertex = next.vertex;
                int nextCost = next.cost;
                int sumCost = nowCost + nextCost;
                
                if (distance[nextVertex] > sumCost) {
                    distance[nextVertex] = sumCost;
                    pQ.offer(new Edge(nextVertex, sumCost));
                }
            }
        }
    }
}