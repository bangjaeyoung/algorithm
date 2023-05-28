class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] result = new int[2];
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        while (end < sequence.length) {
            if (sum < k) {
                end++;
                if (end < sequence.length)
                    sum += sequence[end];
            } else if (sum > k) {
                sum -= sequence[start];
                start++;
            } else {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    result[0] = start;
                    result[1] = end;
                }
                sum -= sequence[start];
                start++;
            }
        }
        return result;
    }
}