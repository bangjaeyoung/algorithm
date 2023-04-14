import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        // to bit
        String[] bits = new String[numbers.length];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = Long.toBinaryString(numbers[i]);
        }
        long[] answer = new long[bits.length];
        for (int i = 0; i < bits.length; i++) {
            String originalStr = bits[i];
            StringBuilder sb = new StringBuilder();
            if (!originalStr.contains("0")) {
                sb.append("1").append("0").append(originalStr.substring(1, originalStr.length()));
            } else {
                int lastIdx = originalStr.lastIndexOf('0');
                if (lastIdx == originalStr.length() - 1) {
                    sb.append(originalStr.substring(0, originalStr.length() - 1)).append("1");
                } else {
                    sb.append(originalStr.substring(0, lastIdx)).append("10").append(originalStr.substring(lastIdx + 2, originalStr.length()));
                }
            }
            answer[i] = Long.parseLong(String.valueOf(sb), 2);
        }
        return answer;
    }
}