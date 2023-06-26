package 프로그래머스.lv0;

public class Sol_120913 {
    public String[] solution(String my_str, int n) {

        int answerArrLen = (my_str.length() + n - 1) / n;
        String[] answer = new String[answerArrLen];

        for (int i = 0; i < answerArrLen; i++) {
            int start = n * i;
            int end = Math.min(start + n, my_str.length());
            answer[i] = my_str.substring(start, end);
        }

        return answer;
    }
}
