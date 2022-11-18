package programmers.level0;

import java.util.Stack;

// 유한소수이면 1, 무한소수이면 2 반환
class Sol_120878 {
    public int solution(int a, int b) {
        int result = 2;

        // 정수는 유한소수로 분류
        if (a % b == 0) return 1;

        a /= gcd(a, b);
        b /= gcd(a, b);

        // 소인수가 2와 5뿐인지 판별하는 과정
//        Stack<Integer> divisor = new Stack<>();
//
//        for (int i = 2; i <= b; i++) {
//            if (b % i == 0) {
//                divisor.add(i);
//                while (b % i == 0) {
//                    b /= i;
//                }
//            }
//        }
//
//        if (divisor.peek() == 2 || divisor.peek() == 5) {
//            divisor.pop();
//            result = 1;
//            if (divisor.peek() == 2) result = 1;
//        }

        return result;
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