import java.io.*;
import java.util.*;

/**
 * Union&Find Algorithm
 */
class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }
}

public class Main {
    static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        unf = new int[V + 1];
        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(v1, v2, cost));
        }

        Collections.sort(edges);

        int ans = 0;
        int cnt = 0;

        for (Edge e : edges) {
            if (union(e.v1, e.v2)) {
                ans += e.cost;
                cnt++;

                if (cnt == E - 1) break;
            }
        }

        System.out.println(ans);
    }

    private static int find(int v) {
        if (unf[v] == v)
            return v;
        else
            return unf[v] = find(unf[v]);
    }

    private static boolean union(int v1, int v2) {
        int fv1 = find(v1);
        int fv2 = find(v2);

        if (fv1 == fv2)
            return false;
        else {
            unf[fv2] = fv1;
            return true;
        }
    }
}
