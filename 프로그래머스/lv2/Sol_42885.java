package programmers.level2;

import java.util.Arrays;

public class Sol_42885 {
    public int solution(int[] people, int limit) {
        int requiredBoatCnt = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--) {
            if (people[min] + people[max] <= limit) min++;

            requiredBoatCnt++;
        }

        return requiredBoatCnt;
    }
}
