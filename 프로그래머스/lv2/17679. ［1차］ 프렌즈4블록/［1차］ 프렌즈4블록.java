import java.util.*;

class Solution {
    static boolean[][] block;
    
    public int solution(int m, int n, String[] board) {
        char[][] copy = new char[m][n];
        for (int i = 0; i < m; i++) {
            copy[i] = board[i].toCharArray();
        }
        
        int count = 0;
        boolean flag = true;
        while (flag) {
            block = new boolean[m][n];
            flag = false;
            
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (copy[i][j] == '~') continue;
                    
                    if (check(i, j, copy)) {
                        block[i][j] = true;
                        block[i][j+1] = true;
                        block[i+1][j] = true;
                        block[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            count += erase(m, n, copy);
        }
        
        return count;
    }
    
    private static boolean check(int m, int n, char[][] board) {
        char ch = board[m][n];
        if (ch == board[m][n+1] && ch == board[m+1][n] && ch == board[m+1][n+1]) {
            return true;
        }
        
        return false;
    }
    
    private static int erase(int m, int n, char[][] board) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (block[i][j]) {
                    board[i][j] = '.';
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            Queue<Character> queue = new LinkedList<>();
            for (int j = m-1; j >= 0; j--) {
                if (board[j][i] == '.') {
                    count++;
                } else {
                    queue.offer(board[j][i]);
                }
            }
            
            int index = m-1;
            while (!queue.isEmpty()) {
                board[index--][i] = queue.poll();
            }
            for (int j = index; j >= 0; j--) {
                board[j][i] = '~';
            }
        }
        
        return count;
    }
}