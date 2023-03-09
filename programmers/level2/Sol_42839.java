package programmers.level2;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Sol_42839 {
    Set<Integer> numbersSet = new HashSet<>();

    public int solution(String numbers) {
        // 1. 모든 숫자의 조합을 생성
        recursive("", numbers);

        // 2. 소수인 숫자의 개수를 세기
        int count = 0;

        Iterator<Integer> iter = numbersSet.iterator();
        while (iter.hasNext()) {
            int number = iter.next();
            if (isPrime(number)) count++;
        }

        // 3. 소수의 개수를 반환
        return count;
    }

    private boolean isPrime(int number) {
        // 1. 숫자가 1보다 작을 경우 소수 아님
        if (number <= 1) return false;

        // 2. 소수 판별 - 에라토스테네스의 체 이용
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0) return false;

        return true;
    }

    private void recursive(String combination, String others) {
        // 1. 숫자 조합을 HashSet에 추가
        if (!combination.equals("")) numbersSet.add(Integer.valueOf(combination));

        // 2. 남은 숫자들 중 한 개를 더한 새로운 조합을 생성
        for (int i = 0; i < others.length(); i++)
            recursive(combination + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
    }
}
