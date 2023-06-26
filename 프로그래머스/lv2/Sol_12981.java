package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Sol_12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int turn = 1;
        String firstWord = words[0];

        List<String> wordsStorage = new ArrayList<>();
        wordsStorage.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            wordsStorage.add(words[i]);

            if (firstWord.charAt(firstWord.length() - 1) != words[i].charAt(0) || checkDuplication(wordsStorage)) {
                answer[0] = i % n + 1;
                answer[1] = turn;
                return answer;
            }

            if ((i + 1) % n == 0) turn++;
            firstWord = words[i];
        }

        return answer;
    }

    static boolean checkDuplication(List<String> wordsStorage) {
        for (int i = 0; i < wordsStorage.size() - 1; i++) {
            String temp = wordsStorage.get(i);

            for (int j = i + 1; j < wordsStorage.size(); j++) {
                if (temp.equals(wordsStorage.get(j))) return true;
            }
        }

        return false;
    }
}
