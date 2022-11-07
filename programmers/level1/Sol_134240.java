package programmers.level1;

public class Sol_134240 {
    public String solution(int[] food) {
        StringBuilder leftToRight = new StringBuilder();
        StringBuilder rightToLeft = new StringBuilder();
        int repeatFoodCount;

        for (int i = 1; i < food.length; i++) {
            repeatFoodCount = food[i] / 2;
            if (repeatFoodCount != 0) {
                for (int j = 0; j < repeatFoodCount; j++) {
                    leftToRight.append(i);
                    rightToLeft.append(i);
                }
            }
        }
        leftToRight.append(0).append(rightToLeft.reverse());

        return String.valueOf(leftToRight);
    }
}
