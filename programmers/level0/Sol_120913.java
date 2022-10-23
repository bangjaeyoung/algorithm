package programmers.level0;

public class Sol_120913 {
    public String[] solution(String my_str, int n) {

        String[] answer = new String[(int) Math.ceil((double) my_str.length() / n)];

        for (int i = 0; i < (int) Math.ceil((double) my_str.length() / n); i++) {
            // 마지막 루프에서의 예외 케이스
            if (i == Math.ceil((double) my_str.length() / n) - 1) {
                answer[i] = my_str.substring(i * n);
            }
            else {
                answer[i] = my_str.substring(i * n, i * n + n);
            }
        }

        return answer;
    }
}
