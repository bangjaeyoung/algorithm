import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int j = commands[i][0];
            int k = commands[i][1];
            int l = commands[i][2];
            int[] tmpArr = new int[k-j+1];
            int tmpIdx = 0;
            for (int m = j-1; m < k; m++) {
                tmpArr[tmpIdx] = array[m];
                tmpIdx++;
            }
            Arrays.sort(tmpArr);
            answer[i] = tmpArr[l-1];
        }
        return answer;
    }
}