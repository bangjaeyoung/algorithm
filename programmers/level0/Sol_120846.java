package programmers.level0;

public class Sol_120846 {
    public int solution(int n) {

        int count;  // 약수의 개수를 할당할 변수
        int finalCount = 0; // 합성수의 개수를 할당할 변수

        for (int i = 1; i <= n; i++) {
            count = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    count++;
            }
`
            if (count >= 3)
                finalCount++;
        }

        return finalCount;
    }
}
