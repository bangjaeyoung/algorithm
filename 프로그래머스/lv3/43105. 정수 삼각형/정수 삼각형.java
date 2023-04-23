class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            // 왼쪽 대각선으로만
            triangle[i][0] += triangle[i-1][0];
            // 중간
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
            // 오른쪽 대각선으로만
            triangle[i][i] += triangle[i-1][i-1];
        }
        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, triangle[triangle.length-1][i]);
        }
        return answer;
    }
}