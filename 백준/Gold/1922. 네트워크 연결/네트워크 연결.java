import java.io.*;
import java.util.*;

/**
 * 최소 스패닝 트리 - 크루스칼 알고리즘(Union Find)
 */
class Edge implements Comparable<Edge> {
    int v1, v2, cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int a, b, c;

        unf = new int[N + 1];
        for (int i = 0; i < N; i++) {
            unf[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);

        int cnt = 0, ans = 0;
        for (Edge e : edges) {
            if (cnt == N - 1) break;

            int fv1 = find(e.v1);
            int fv2 = find(e.v2);

            if (fv1 != fv2) {
                union(fv1, fv2);
                ans += e.cost;
                cnt++;
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

    private static void union(int v1, int v2) {
        int fv1 = find(v1);
        int fv2 = find(v2);

        if (fv1 != fv2)
            unf[fv1] = fv2;
    }
}
