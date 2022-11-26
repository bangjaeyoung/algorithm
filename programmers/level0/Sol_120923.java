package programmers.level0;

public class Sol_120923 {
    public int[] solution(int num, int total) {
        for (int i = 0; i < num; i++) {
            total -= i;
        }

        int baseNum = total / num;
        int[] result = new int[num];

        for (int i = 0; i < result.length; i++) {
            result[i] = baseNum + i;
        }

        return result;
    }
}
