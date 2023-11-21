import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int size = stations.length;

        for (int station : stations) {
            if (start < station - w) {
                int end = station - w;
                int len = end - start;

                answer += len / (w * 2 + 1);
                if (len % (w * 2 + 1) > 0) {
                    answer++;
                }
            }

            start = station + w + 1;
        }

        if(stations[size - 1] + w + 1 <= n){
            start = stations[size - 1] + w + 1;
            int end = n + 1;
            int len = end - start;

            answer += len / (w * 2 + 1);
            if (len % (w * 2 + 1) > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
