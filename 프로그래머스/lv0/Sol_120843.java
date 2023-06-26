package 프로그래머스.lv0;

public class Sol_120843 {
    public int solution(int[] numbers, int k) {

        int answer = 0;
        int kCount = 0;

        for (int i = 0; i < numbers.length; ) {
            answer = numbers[i];
            kCount++;
            if (kCount == k) break;
            i += 2;
            if (i == numbers.length) i = 0;
            if (i == numbers.length + 1) i = 1;
        }
        return answer;
    }
}
