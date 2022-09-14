package programmers.level1;

public class Sol_87389 {

    // n을 answer로 나눈 나머지가 1이 되게 하는 가장 작은 자연수 찾기
    // = (n-1)을 answer로 나눈 나머지가 0이 되게 하는 가장 작은 자연수 찾기
    // 1은 제외, answer = 2부터 1씩 늘려가며 찾기

    public int solution(int n) {

        int answer = 2;

        while (true) {

            if ((n - 1) % answer == 0) {
                return answer;
            }

            answer++;
        }
    }
}
