import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v1, v2, cost;

    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Main {
    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        unf = new int[V + 1];
        for (int i = 1; i <= V; i++)
            unf[i] = i;

        List<Edge> edges = new ArrayList<>();
        int v1, v2, cost;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(v1, v2, cost));
        }

        Collections.sort(edges);

        int ans = 0, cnt = 0;
        for (Edge ob : edges) {
            int fv1 = find(ob.v1);
            int fv2 = find(ob.v2);

            if (fv1 != fv2) {
                union(fv1, fv2);
                ans += ob.cost;
                cnt++;
            }

            if (cnt - 1 == V) break;
        }

        System.out.println(ans);
    }

    private static int find(int vertex) {
        if (vertex == unf[vertex])
            return vertex;
        else
            return unf[vertex] = find(unf[vertex]);
    }

    private static void union(int v1, int v2) {
        unf[v1] = v2;
    }
}
