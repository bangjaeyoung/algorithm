package programmers.level0;

public class Sol_120808 {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];

        int lcm = num1 * num2 / gcd(num1, num2);
        answer[0] = denum1 * (lcm / num1) + denum2 * (lcm / num2);
        answer[1] = lcm;

        // 약분
        int divideNum = gcd(answer[0], answer[1]);
        answer[0] /= divideNum;
        answer[1] /= divideNum;

        return answer;
    }

    // 최대공약수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
