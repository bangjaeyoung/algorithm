package programmers.level2;

import java.util.Arrays;

/**
 * 1. 인자로 받은 n을 k진수로 표현한다.
 * 2. k진수로 표현된 수를 0을 기준으로 나누어 배열에 담는다
 * ex) 211020101011 → [211, 2, 1, 1, 11]
 * 3. 배열을 순회하면서 소수가 아닌 수에 대해서는 공백으로 바꾼다.
 * ex) [211, 2, 1, 1, 11] → [211, 2, , , 11]
 * 4. 공백이 아닌 수들의 개수를 정답으로 반환한다.
 **/

public class Sol_92335 {
    public int solution(int n, int k) {
        String num = Integer.toString(n, k);

        String[] numList = num.split("0+");

        return (int) Arrays.stream(numList).map(el -> isPrime(Long.parseLong(el)) ? el : "").filter(el -> !el.equals("")).count();
    }

    private boolean isPrime(long num) {
        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;

        return true;
    }
}
