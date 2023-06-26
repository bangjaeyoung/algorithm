package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Sol_84512 {
    public static final String[] WORDS = {"A", "E", "I", "O", "U"};
    public static final int MAX_LENGTH = 5;
    public static List<String> dictionary = new ArrayList<>();

    public int solution(String word) {
        // 1. DFS(깊이 우선 탐색)로 사전에 모든 단어 등록
        for (String WORD : WORDS)
            dfs(dictionary, WORD);

        // 2. 사전에서는 0번째가 없기 때문에, 1을 더한 값이 사전에서의 실제 위치
        return dictionary.indexOf(word) + 1;
    }

    // 맨 처음 "A"를 인자로 받으면, "A"로 시작하는 모든 단어들을 사전에 추가
    private void dfs(List<String> dictionary, String str) {
        if (str.length() > MAX_LENGTH) return;

        dictionary.add(str);

        for (String WORD : WORDS)
            dfs(dictionary, str + WORD);
    }
}
