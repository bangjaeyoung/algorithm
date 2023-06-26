package 프로그래머스.lv0;

public class Sol_120818 {
    public int solution(int price) {

        double discountRate = 0;

        if (price >= 100_000) {
            discountRate = 0.05;

            if (price >= 300_000) {
                discountRate = 0.1;

                if (price >= 500_000) {
                    discountRate = 0.2;
                }
            }
        }
        return (int) Math.floor(price * (1 - discountRate));
    }
}
