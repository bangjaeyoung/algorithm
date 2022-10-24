package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class Sol_12977 {
    public int solution(int[] nums) {

        List<Integer> sumList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sumList.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        int primeCount = 0;

        for (Integer sum : sumList) {
            if (isPrime(sum)) primeCount++;
        }

        return primeCount;
    }

    public boolean isPrime(int num) {

        if (num == 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
