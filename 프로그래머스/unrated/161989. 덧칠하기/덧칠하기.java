class Solution {
    public int solution(int n, int m, int[] section) {
        int lastPoint = 0;
        int count = 0;
        for (int i = 0; i < section.length; i++) {
            if (lastPoint < section[i]) {
                lastPoint = section[i] + m - 1;
                count++;
            }
        }
        return count;
    }
}