package 프로그래머스.lv0;

public class Sol_120840 {
    public int solution(int balls, int share) {
        return combination(balls, share);
    }

    static int combination(int n, int r) {
        if(n == r || r == 0) return 1;
        else return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}

// class Sol_120840 {
//     public long solution(int balls, int share) {
//         share = Math.min(balls - share, share);
//
//         if (share == 0)
//             return 1;
//
//         long result = solution(balls - 1, share - 1);
//         result *= balls;
//         result /= share;
//
//         return result;
//     }
// }
