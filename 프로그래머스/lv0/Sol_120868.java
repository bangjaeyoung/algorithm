package 프로그래머스.lv0;

import java.util.ArrayList;
import java.util.List;

/**
 * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
 */
public class Sol_120868 {
    public long solution(int[] sides) {
        int maxLen = Math.max(sides[0], sides[1]);
        int minLen = Math.min(sides[0], sides[1]);

        List<Integer> lenList = new ArrayList<>();

        for (int i = maxLen - minLen + 1; i <= maxLen; i++) {
            lenList.add(i);
        }

        // 여기서의 가장 긴 변은 주어진 두 값 이외의 값
        for (int i = maxLen; i < sides[0] + sides[1]; i++) {
            lenList.add(i);
        }

        return lenList.stream().distinct().count();
    }
}

// class Sol_120868 {
//     public int solution(int[] sides) {
//         int answer = 0;
//
//         for (int i = Math.abs(sides[0] - sides[1]) + 1; i < sides[0] + sides[1]; i++) answer++;
//
//         return answer;
//     }
// }
