package programmers.level1;

public class Sol_12921 {
    public int solution(int n) {

        int count = 0;
        for (int i = 2; i <= n; i++) {

            boolean flag = true;
            int a = (int) Math.sqrt(i);

            for (int j = 2; j <= a; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        return count;
    }
}
