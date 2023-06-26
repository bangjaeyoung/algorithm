package 프로그래머스.lv0;

import java.util.ArrayList;

public class Sol_120905 {
    public int[] solution(int n, int[] numList) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int num : numList) {
            if (num % n == 0) arrayList.add(num);
        }

        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}
