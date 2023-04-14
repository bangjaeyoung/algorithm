import java.util.*;

class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long rs = x, re = x, cs = y, ce = y;
        for (int i = queries.length - 1; i >= 0; i--) {
            int dir = queries[i][0], dx = queries[i][1];
            
            switch (dir) {
                case 0:
                    // L
                    if (cs > 0) cs += dx;
                    ce = Math.min(m - 1, ce + dx);
                    break;
                case 1:
                    // R
                    if (ce < m - 1) ce -= dx;
                    cs = Math.max(0, cs - dx);
                    break;
                case 2:
                    // U
                    if (rs > 0) rs += dx;
                    re = Math.min(n - 1, re + dx);
                    break;
                case 3:
                    // D
                    if (re < n - 1) re -= dx;
                    rs = Math.max(0, rs - dx);
                    break;
            }
            if (rs >= n || re < 0 || cs >= m || ce < 0) return 0;
        }
        return (re - rs + 1) * (ce - cs + 1);
    }
}