package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol_25501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] result = isPalindromeArray(br.readLine());
            int isPal = result[0];
            int recursionCnt = result[1];

            sb.append(isPal).append(" ").append(recursionCnt).append("\n");
        }
        System.out.println(sb);
    }

    // 문자열과 문자열의 처음 인덱스, 마지막 인덱스를 인자로 받는 메서드
    // 반환타입 -> [팰린드롬 여부(0 or 1), 재귀 호출 카운트]
    public static int[] isPalindrome(String str, int first, int last) {

        recursionCount++;

        if (first >= last) return new int[]{1, recursionCount};
        else if (str.charAt(first) != str.charAt(last)) return new int[]{0, recursionCount};

        return isPalindrome(str, first + 1, last - 1);
    }

    // 재귀 호출 시, 증가할 카운트
    public static int recursionCount = 0;

    public static int[] isPalindromeArray(String str) {

        recursionCount = 0;

        return isPalindrome(str, 0, str.length() - 1);
    }
}
