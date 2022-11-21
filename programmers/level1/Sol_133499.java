package programmers.level1;

public class Sol_133499 {
    public int solution(String[] babbling) {
        int pronounceableWordsCount = 0;

        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].replaceAll("(ayaaya)|(yeye)|(woowoo)|(mama)"," ").contains(" ")) babbling[i] = "X";

            babbling[i] = babbling[i].replaceAll("(aya)|(ye)|(woo)|(ma)"," ");
            if (babbling[i].strip().isBlank()) pronounceableWordsCount++;
        }
        return pronounceableWordsCount;
    }
}
