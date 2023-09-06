import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int vertex, cost;

    Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int N, M;
    static List<List<Edge>> graph;
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        int from, to, cost;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        solve(start);

        System.out.println(dis[end]);
    }

    private static void solve(int vertex) {
        Queue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(vertex, 0));
        dis[vertex] = 0;

        while (!pQ.isEmpty()) {
            Edge now = pQ.poll();
            int nowV = now.vertex;
            int nowC = now.cost;

            if (nowC > dis[nowV]) continue;

            for (Edge o : graph.get(nowV)) {
                if (dis[o.vertex] > nowC + o.cost) {
                    dis[o.vertex] = nowC + o.cost;
                    pQ.offer(new Edge(o.vertex, nowC + o.cost));
                }
            }
        }
    }
}
