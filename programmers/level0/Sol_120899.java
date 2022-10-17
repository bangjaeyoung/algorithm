package programmers.level0;

public class Sol_120899 {
    public int[] solution(int[] array) {

        int max = array[0];
        int maxIdx = -1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIdx = i;
            }
        }
        return new int[]{max, maxIdx};
    }
}
