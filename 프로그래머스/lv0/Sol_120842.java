package 프로그래머스.lv0;

public class Sol_120842 {
    public int[][] solution(int[] num_list, int n) {

        int[][] result = new int[num_list.length / n][n];

        for (int i = 0; i < num_list.length; i++) {
            result[i / n][i % n] = num_list[i];
        }
        return result;
    }
}
