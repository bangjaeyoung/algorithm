package 프로그래머스.lv0;

public class Sol_120912 {
    public int solution(int[] array) {

        int answer = 0;

        for (int num : array) {
            while (num > 0) {
                if (num % 10 == 7) answer++;

                num /= 10;
            }
        }

        return answer;
    }
}
