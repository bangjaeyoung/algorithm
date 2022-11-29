package programmers.level0;

// 유한소수이면 1, 무한소수이면 2 반환
class Sol_120878 {
    public int solution(int a, int b) {
        int dividedB = b / gcd(a, b);

        while (dividedB != 1) {
            if (dividedB % 2 == 0) {
                dividedB /= 2;
            } else if (dividedB % 5 == 0) {
                dividedB /= 5;
            } else {
                return 2;
            }
        }
        return 1;
    }

    // 최대공약수
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
