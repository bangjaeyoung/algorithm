import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        for (int[] size : sizes) {
            Arrays.sort(size);
        }
        int a = 0, b = 0;
        for (int[] size : sizes) {
            a = Math.max(a, size[0]);
            b = Math.max(b, size[1]);
        }
        return a * b;
    }
}