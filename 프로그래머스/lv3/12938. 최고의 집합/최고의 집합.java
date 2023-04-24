class Solution {
    public int[] solution(int n, int s) {
        // 만들 수 없는 경우
        if (s < n) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int quotient = s / n;
        int remainder = s % n;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = quotient;
        }
        if (remainder != 0) {
            for (int i = 0; i < remainder; i++) {
                answer[(answer.length-1)-i]++;
            }
        }
        return answer;
    }
}