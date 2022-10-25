package programmers.level0;

public class Sol_120887 {
    public int solution(int i, int j, int k) {

        int kCount = 0;

        for (int num = i; num <= j; num++) {
            int tmp = num;
            while (tmp != 0) {
                if (tmp % 10 == k) kCount++;
                tmp /= 10;
            }
        }
        return kCount;
    }
}
