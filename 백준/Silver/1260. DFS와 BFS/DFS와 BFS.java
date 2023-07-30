import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static List<List<Integer>> graph;
    static List<Integer> answer;
    static int[] check;
    static int n, m, v, count;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        answer = new ArrayList<>();
        check = new int[n + 1];
        count = 1;

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

        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        answer.add(v);
        check[v] = 1;
        main.dfs(v);
        for (int ans : answer) {
            System.out.print(ans + " ");
        }

        answer = new ArrayList<>();
        check = new int[n + 1];
        System.out.println();

        answer.add(v);
        main.bfs(v);
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }

    private void dfs(int node) {
        if (count == n) return;
        else {
            for (int nextNode : graph.get(node)) {
                if (check[nextNode] == 0) {
                    check[nextNode] = 1;
                    answer.add(nextNode);
                    count++;
                    dfs(nextNode);
                }
            }
        }
    }

    private void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        check[vertex] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentVertex = queue.poll();

                for (int nextVertex : graph.get(currentVertex)) {
                    if (check[nextVertex] == 0) {
                        check[nextVertex] = 1;
                        answer.add(nextVertex);
                        queue.offer(nextVertex);
                    }
                }
            }
        }
    }
}
