package programmers.level1;

public class Sol_140108 {
    public int solution(String s) {
        char c = s.charAt(0);
        int sameCnt = 1;
        int differentCnt = 0;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                sameCnt++;
            } else differentCnt++;

            if (sameCnt == differentCnt) {
                result++;
                if (i != s.length() - 1) {
                    c = s.charAt(i + 1);
                    sameCnt = 1;
                    differentCnt = 0;
                    i++;
                }
            }
        }
        if (sameCnt != differentCnt) result++;

        return result;
    }
}
