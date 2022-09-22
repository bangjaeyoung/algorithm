package programmers.level1;

public class Sol_12934 {

    public long solution(long n) {

        for (long i = 1; i <= n; i++) {

            if (n == i * i) {
                return (i + 1) * (i + 1);
            }
        }
        return -1;
    }
}
