package coplit;

//1. 입력 값에 따른 빈 배열 생성
//2. 초기 값 설정
//3. 점화식 기반으로 계산 값 적용
//4. 특정 입력 값에 따른 계산 값 적용
public class Sol_29 {
    public int tiling(int num) {
        // 예외
        if (num == 1) return 1;

        int[] dp = new int[num + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[num];
    }
}
