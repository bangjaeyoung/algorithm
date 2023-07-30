import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int n, m;
    static int[] distance, check;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        distance = new int[n + 1];
        check = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt(), to = sc.nextInt();
            graph.get(from).add(to);
        }

        main.bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + distance[i]);
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
                        distance[nextVertex] = distance[currentVertex] + 1;
                        queue.offer(nextVertex);
                    }
                }
            }
        }
    }
}
