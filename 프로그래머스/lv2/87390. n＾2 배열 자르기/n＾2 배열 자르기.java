class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        for (int i = 0; left <= right; i++, left++) {
            answer[i] = (int) Math.max(left % n, left / n) + 1;
        }
        return answer;
    }
}