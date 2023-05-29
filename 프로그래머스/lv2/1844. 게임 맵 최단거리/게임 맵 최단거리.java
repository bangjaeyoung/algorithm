import java.util.*;

class Solution {
    static int n, m;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        visited[0][0] = true;
        bfs(0, 0, maps);
        
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
    
    private void bfs(int i, int j, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int k = 0; k < 4; k++) {
                int nextX = now[0] + dx[k];
                int nextY = now[1] + dy[k];
                
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] != 0) {
                        visited[nextX][nextY] = true;
                        maps[nextX][nextY] = maps[now[0]][now[1]] + 1;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}