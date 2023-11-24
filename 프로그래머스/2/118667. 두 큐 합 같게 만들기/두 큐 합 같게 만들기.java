import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int len = queue1.length;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < len; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        long total = sum1 + sum2;
        if (total % 2 == 1) {
            return -1;
        }
        
        while (sum1 != sum2) {
            if (answer > (len + len) * 2) {
                return -1;
            }
            
            int val = 0;
            if (sum1 > sum2) {
                val = q1.poll();
                sum1 -= val;
                sum2 += val;
                q2.offer(val);
            } else if (sum1 < sum2) {
                val = q2.poll();
                sum2 -= val;
                sum1 += val;
                q1.offer(val);
            } else {
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}
