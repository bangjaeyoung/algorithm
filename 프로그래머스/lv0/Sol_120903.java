package 프로그래머스.lv0;

import java.util.*;

public class Sol_120903 {
    public int solution(String[] s1, String[] s2) {

        List<String> listS1 = new ArrayList<>(Arrays.asList(s1));
        List<String> listS2 = Arrays.asList(s2);

        listS1.retainAll(listS2);

        return listS1.size();
    }
}
