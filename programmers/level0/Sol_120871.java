package programmers.level0;

import java.util.ArrayList;
import java.util.List;

public class Sol_120871 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }
        return answer;
    }

//    public int solution(int n) {
//        List<String> arrayList = new ArrayList<>();
//        for (int i = 1; i < n * 3; i++) {
//            if (i % 3 != 0 && !String.valueOf(i).contains("3")) {
//                arrayList.add(String.valueOf(i));
//            }
//        }
//        return Integer.parseInt(arrayList.get(n - 1));
//    }
}
