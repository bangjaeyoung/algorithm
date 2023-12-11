import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board, dis;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        dis = new int[n][m];
        visited = new boolean[n][m];
        
        int startX = 0;
        int startY = 0;
        for (int h = 0; h < n; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < m; w++) {
                board[h][w] = Integer.parseInt(st.nextToken());
                if (board[h][w] == 1) {
                    dis[h][w] = -1;
                } else if (board[h][w] == 2) {
                    startX = h;
                    startY = w;
                }
            }
        }
        
        bfs(startX, startY);
        
        for (int h = 0; h < n; h++) {
            for (int w = 0; w < m; w++) {
                result.append(dis[h][w]).append(" ");
            }
            result.append("\n");
        }
        
        System.out.println(result);
    }
    
    private static void bfs(int h, int w) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{h, w});
        visited[h][w] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (!visited[nextX][nextY] && board[nextX][nextY] != 0) {
                        dis[nextX][nextY] = dis[cur[0]][cur[1]] + 1;
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
