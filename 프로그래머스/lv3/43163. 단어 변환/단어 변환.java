class Solution {
    static int answer = 50;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        // 변환할 수 없을 경우, 0 반환
        if (!check(target, words)) {
            return 0;
        }
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    private void dfs(String begin, String target, String[] words, int cnt) {
        // target과 동일할 경우, 기존 answer 값과 비교해서 더 작은 값을 answer에 저장
        if (begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            // begin과 비교해 동일 문자가 몇 개인지 세기
            int tmp = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    tmp++;
                }
            }
            // 한 문자씩만 바뀔 수 있으므로
            if (tmp == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false; // 다음 순회 때를 위해 방문 여부 초기화
            }
        }
        
    }
    
    private boolean check(String target, String[] words) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }
}