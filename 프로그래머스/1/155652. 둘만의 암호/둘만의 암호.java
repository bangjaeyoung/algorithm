class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for (char c : s.toCharArray()) {
            for (int i = 0; i < index; i++) {
                c++;
                if (c > 'z') {
                    c -= 26;
                }
                if (skip.contains(String.valueOf(c))) {
                    i--;
                }
            }
            answer.append(c);
        }
        return answer.toString();
    }
}
