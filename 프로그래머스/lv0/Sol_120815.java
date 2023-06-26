package 프로그래머스.lv0;

public class Sol_120815 {
    public int solution(int n) {

        int d = gcd(n, 6);

        // 최소공배수 / 6(피자 6조각)
        return (n * 6 / d) / 6;
    }

    // 최대공약수 구하는 메서드
    public int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }
        return a;
    }
}
