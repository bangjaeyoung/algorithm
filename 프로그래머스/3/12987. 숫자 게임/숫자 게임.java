import java.util.*;

// 2356
// 1234
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int aPoint = 0;
        int bPoint = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++) {
            if (B[bPoint] > A[aPoint]) {
                answer++;
                aPoint++;
                bPoint++;
            } else {
                bPoint++;
            }
        }
        
        return answer;
    }
}
