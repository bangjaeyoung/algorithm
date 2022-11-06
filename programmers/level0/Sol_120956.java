package programmers.level0;

public class Sol_120956 {
    public int solution(String[] babbling) {
        int pronounceableWord = 0;

        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", " ").replace("ye", " ").replace("woo", " ").replace("ma", " ");
            if (babbling[i].strip().equals("")) pronounceableWord++;
        }
        return pronounceableWord;
    }
}
