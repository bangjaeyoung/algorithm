package programmers.level1;

public class Sol_131128 {
    public String solution(String X, String Y) {
        if (!checkPair(countSameString(X, Y))) return "-1";

        return findMaxNum(countSameString(X, Y));
    }

    static int[] countSameString(String str1, String str2) {
        int[] sameCount = new int[9];
        for (int i = 0; i < str1.length(); i++) {
            if (str2.contains(String.valueOf(str1.charAt(i)))) {
                sameCount[Character.getNumericValue(str1.charAt(i))]++;
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str1.contains(String.valueOf(str2.charAt(i)))) {
                sameCount[Character.getNumericValue(str2.charAt(i))]++;
            }
        }
        return sameCount;
    }

    static boolean checkPair(int[] arr) {
        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        return sum != 0;
    }

    static String findMaxNum(int[] arr) {
        StringBuilder pairStr = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (arr[i] > 1) {
                pairStr.append(i);
                arr[i] -= 2;
                if (i == 0) break;
            }
        }
        return String.valueOf(pairStr);
    }
}
