import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<long[]> set = new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                long dominator = A * D - B * C;
                if (dominator == 0) break;
                long[] arr = new long[2];
                double x = (double) (B * F - E * D) / dominator;
                double y = (double) (E * C - A * F) / dominator;
                if (x % 1 == 0 && y % 1 == 0) {
                    arr[0] = (long) x;
                    arr[1] = (long) y;
                    set.add(arr);
                }
            }
        }
        Comparator<long[]> comparator = (a1, a2) -> {
            if (a1[1] != a2[1]) {
                return Long.compare(a2[1], a1[1]);
            } else {
                return Long.compare(a2[0], a1[0]);
            }
        };
        TreeSet<long[]> sortedSet = new TreeSet<>(comparator);
        sortedSet.addAll(set);
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        for (long[] arr : sortedSet) {
            long x = arr[0];
            long y = arr[1];
            if (x <= minX) minX = x;
            if (x >= maxX) maxX = x;
            if (y <= minY) minY = y;
            if (y >= maxY) maxY = y;
        }
        List<long[]> sortedSetCopy = new ArrayList<>(sortedSet);
        List<String> answer = new ArrayList<>();
        for (long i = maxY; i >= minY; i--) {
            StringBuilder sb = new StringBuilder();
            char[] charArr = new char[(int) (maxX - minX + 1)];
            for (int j = 0; j < charArr.length; j++) {
                charArr[j] = '.';
            }
            for (int j = 0; j < sortedSetCopy.size(); j++) {
                long[] temp = sortedSetCopy.get(j);
                if (i == temp[1]) {
                    if (minX < 0) {
                        charArr[(int) (temp[0] - minX)] = '*';
                    } else {
                        charArr[(int) (temp[0] - minX)] = '*';
                    }
                }
            }
            for (int j = 0; j < charArr.length; j++) {
                sb.append(charArr[j]);
            }
            answer.add(String.valueOf(sb));
        }
        return answer.toArray(new String[0]);
    }
}