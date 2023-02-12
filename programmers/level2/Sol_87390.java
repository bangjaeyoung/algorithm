package programmers.level2;


/**
 * 1. 결과로 나올 배열을 생성 - (right - left + 1) 크기의 배열
 * 2. 2차원 배열의 (행 + 1)을 y, (열 + 1)을 x로 두고 진행 - 1을 더하는 이유는 1부터 시작하기 때문
 * 3. y = (left / n) + 1, x = (right % n) + 1 이라는 특성을 이용
 * 4. y, x 중 큰 값이 그 행과 열에 맞는 숫자가 되기 때문에 둘 중 큰 값을 결과 배열에 저장
 */
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
