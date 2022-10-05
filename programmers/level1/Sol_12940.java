package programmers.level1;

// 인자로 받는 두 수의 최대공약수와 최소공배수를 구하여라.
// 유클리드 호제법 이용
public class Sol_12940 {

    public int[] solution(int n, int m) {

        return new int[]{gdc(n, m), lcm(n, m)};
    }

    // 최대 공약수
    public int gdc(int n, int m) {

        if (n < m) {
            int tmp = n;
            n = m;
            m = tmp;
        }

        while (m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }

        return n;
    }

    public int lcm(int n, int m) {

        return n * m / gdc(n, m);
    }
}
