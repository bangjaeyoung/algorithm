package programmers.level2;

public class Sol_87390 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        for (int i = 0; i < answer.length; i++) {
            int y = (int) (left / n) + 1;
            int x = (int) (left % n) + 1;

            answer[i] = Math.max(y, x);

            left++;
        }

        return answer;
    }
}
