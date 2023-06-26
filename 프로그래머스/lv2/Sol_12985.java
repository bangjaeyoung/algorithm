package programmers.level2;

public class Sol_12985 {
    public int solution(int n, int a, int b) {
        int roundCount = 1;

        while (true) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;

            if (a == b) break;

            roundCount++;
        }

        return roundCount;
    }
}
