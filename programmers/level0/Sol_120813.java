package programmers.level0;

import java.util.ArrayList;

public class Sol_120813 {
    public int[] solution(int n) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            }
        }

        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}
