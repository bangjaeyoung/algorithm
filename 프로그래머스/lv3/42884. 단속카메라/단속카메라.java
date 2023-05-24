import java.util.*;

class Solution {
   public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
        int count = 0;
        int position = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (route[0] > position) {
                count++;
                position = route[1];
            }
        }

        return count;
    }
}