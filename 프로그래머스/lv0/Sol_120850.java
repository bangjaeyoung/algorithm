package 프로그래머스.lv0;

import java.util.ArrayList;

class Sol_120850 {
    public int[] solution(String my_string) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++) {

            if (Character.isDigit(my_string.charAt(i))) {
                arrayList.add(Character.getNumericValue(my_string.charAt(i)));
            }
        }

        return arrayList.stream().sorted().mapToInt(i -> i).toArray();
    }
}
