package programmers.level2;

public class Sol_12980 {
    public int solution(int n) {
        int batteryUsages = 0;

        while (n != 0) {
            if (n % 2 == 0)
                n /= 2;
            else {
                n--;
                batteryUsages++;
            }
        }

        return batteryUsages;
    }
}
