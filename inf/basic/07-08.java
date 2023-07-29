import java.util.*;

public class Main {
    static int[] dis = {1, -1, 5};
    static boolean[] visited = new boolean[10001];

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(), e = sc.nextInt();
        System.out.print(main.bfs(s, e));
    }

    private int bfs(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;

        int depth = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int cur = queue.poll();

                for (int d : dis) {
                    int next = cur + d;

                    if (next == e)
                        return depth + 1;
                    
                    if (next >= 1 && next <= 10_000 && !visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }

            depth++;
        }

        return depth;
    }
}
