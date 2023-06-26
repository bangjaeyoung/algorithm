package programmers.level1;

// 부족한 금액을 구하라.
// 1. n번째까지의 이용료 구하기
// 3. 현재 가진 돈(money) < n번째까지의 이용료(totalPrice) -> totalPrice - money 반환
// 4. 현재 가진 돈(money) >= n번째까지의 이용료(totalPrice) -> 0을 반환
class Sol_82612 {
    public long solution(int price, int money, int count) {

        long totalPrice = 0;

        // n번째까지의 이용료 구하기
        for (int i = 1; i <= count; i++) {
            totalPrice += (long) price * i;
        }

        // n번째까지의 이용료의 합이 현재 가진 돈보다 클 경우,
        if (totalPrice > money) {
            return totalPrice - money;
        }
        else return 0;
    }
}
