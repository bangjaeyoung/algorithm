package programmers.level2;

public class Sol_12953 {
    public int solution(int[] arr) {
        if (arr.length == 1) return arr[0];

        int lcm = getLCM(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++)
            lcm = getLCM(lcm, arr[i]);

        return lcm;
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }
}
