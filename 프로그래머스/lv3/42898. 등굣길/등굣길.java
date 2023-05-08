class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        int mod = 1_000_000_007;
        // 시작점 초기화
        map[0][0] = 1;
        // 웅덩이 설정
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        // 경로 개수 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 웅덩이일 경우,
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                // + 윗칸 값
                if (i != 0) {
                    map[i][j] += map[i-1][j] % mod;
                }
                // + 왼쪽칸 값
                if (j != 0) {
                    map[i][j] += map[i][j-1] % mod;
                }
            }
        }
        return map[n-1][m-1] % mod;
    }
}