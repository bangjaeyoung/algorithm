/**
 * dp 이용
 * 점화식: dp[n] = max(dp[n-2] + sticker[n], dp[n-1])
 */
class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        
        if (len == 1) {
            return sticker[0];
        }
        
        int[] firstDp = new int[len]; //첫 번째 인덱스부터 시작
        int[] secondDp = new int[len]; //두 번째 인덱스부터 시작
        
        firstDp[0] = sticker[0];
        firstDp[1] = sticker[0];
        
        secondDp[0] = 0;
        secondDp[1] = sticker[1];
        
        for (int i = 2; i < len; i++) {
            firstDp[i] = Math.max(firstDp[i - 2] + sticker[i], firstDp[i - 1]);
            secondDp[i] = Math.max(secondDp[i - 2] + sticker[i], secondDp[i - 1]);
        }
        
        return Math.max(firstDp[len - 2], secondDp[len - 1]);
    }
}
