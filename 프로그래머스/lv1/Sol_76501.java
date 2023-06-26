package programmers.level1;

public class Sol_76501 {

    public int solution(int[] absolutes, boolean[] signs) {

        // 배열의 모든 합을 넣을 변수 선언
        int sum = 0;

        // signs 배열의 요소가 false일 경우, absolutes 배열의 요소를 음수로 바꿈
        for (int i = 0; i < signs.length; i++) {
            if (!signs[i]) {
                absolutes[i] *= -1;
            }
            sum += absolutes[i];
        }
        return sum;
    }
}
