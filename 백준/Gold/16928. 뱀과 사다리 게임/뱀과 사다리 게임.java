import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited = new boolean[101];
    static int[] count = new int[101];
    static int[] ladderAndSnake = new int[101];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 사다리 설정
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            ladderAndSnake[x] = y;
        }
        
        // 뱀 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            ladderAndSnake[u] = v;
        }
        
        bfs();
    }
    
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        count[1] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            if (now == 100) {
                System.out.println(count[now]);
                return;
            }
            
            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                
                if (next > 100) continue;
                if (visited[next]) continue;
                
                visited[next] = true;
                
                // 뱀과 사다리가 있을 때
                if (ladderAndSnake[next] != 0) {
                    if (!visited[ladderAndSnake[next]]) {
                        queue.offer(ladderAndSnake[next]);
                        visited[ladderAndSnake[next]] = true;
                        count[ladderAndSnake[next]] = count[now] + 1;
                    }
                }
                // 아무것도 없을 때
                else {
                    queue.offer(next);
                    visited[next] = true;
                    count[next] = count[now] + 1;
                }
            }
        }
    }
}
