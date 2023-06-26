package programmers.level2;

import java.util.HashSet;

public class Sol_64065 {
    public int[] solution(String s) {
        String[] split = s.split("},\\{");
        split[0] = split[0].replaceAll("[{}]", "");
        split[split.length - 1] = split[split.length - 1].replaceAll("[{}]", "");

        String[][] sortedByLength = new String[split.length][];

        for (String value : split) {
            String[] ss = value.split(",");
            sortedByLength[ss.length - 1] = ss;
        }

        HashSet<String> mySet = new HashSet<>();
        String[] answerStrArr = new String[split.length];

        for (int i = 0; i < sortedByLength.length; i++) {
            for (int j = 0; j < sortedByLength[i].length; j++) {
                if (!mySet.contains(sortedByLength[i][j])) {
                    answerStrArr[i] = sortedByLength[i][j];
                    mySet.add(sortedByLength[i][j]);
                }
            }
        }

        int[] answer = new int[answerStrArr.length];

        for (int i = 0; i < answerStrArr.length; i++)
            answer[i] = Integer.parseInt(answerStrArr[i]);

        return answer;
    }
}
