package programmers.level1;

import java.util.ArrayList;
import java.util.List;

class Sol_42840 {
    public int[] solution(int[] answers) {

        StringBuilder firstMan = new StringBuilder(); //12345...
        StringBuilder secondMan = new StringBuilder(); //21232425...
        StringBuilder thirdMan = new StringBuilder(); //3311224455...

        for (int i = 0; i < answers.length / 5 + 1; i++) {
            firstMan.append("12345");
            secondMan.append("21232425");
            thirdMan.append("3311224455");
        }

        int[] solveCount = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == Character.getNumericValue(String.valueOf(firstMan).charAt(i))) solveCount[0]++;
            if (answers[i] == Character.getNumericValue(String.valueOf(secondMan).charAt(i))) solveCount[1]++;
            if (answers[i] == Character.getNumericValue(String.valueOf(thirdMan).charAt(i))) solveCount[2]++;
        }

        List<Integer> result = new ArrayList<>();
        int max = -1;

        // 맞힌 문제 수의 최대값 구하기
        for (int solve : solveCount) {
            if (solve > max) max = solve;
        }

        // 그 최대값을 값으로 가지는 사람을 추출
        for (int i = 0; i < solveCount.length; i++) {
            if (solveCount[i] == max) result.add(i + 1); // 인덱스는 0, 1, 2 / 사람은 1, 2, 3
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
