package programmers.level1;

public class Sol_67256 {
    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();
        int leftHand = 10;  // *
        int rightHand = 12; // #

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) numbers[i] = 11;   // 순서에 맞게 0을 11로 변경
            // 3, 6, 9를 누를 경우
            if (numbers[i] % 3 == 0) {
                result.append("R");
                rightHand = numbers[i];
            }
            // 1, 4, 7을 누를 경우
            else if (numbers[i] % 3 == 1) {
                result.append("L");
                leftHand = numbers[i];
            }
            // 2, 5, 8, 0을 누를 경우
            else {
                // 오른손과의 거리가 더 짧을 경우
                if (distanceCheck(leftHand, numbers[i]) > distanceCheck(rightHand, numbers[i])) {
                    result.append("R");
                    rightHand = numbers[i];
                }
                // 왼손과의 거리가 더 짧을 경우
                else if (distanceCheck(rightHand, numbers[i]) > distanceCheck(leftHand, numbers[i])) {
                    result.append("L");
                    leftHand = numbers[i];
                }
                // 두 손과의 거리가 같을 경우
                else {
                    if (hand.equals("right")) {
                        result.append("R");
                        rightHand = numbers[i];
                    } else {
                        result.append("L");
                        leftHand = numbers[i];
                    }
                }
            }
        }
        return String.valueOf(result);
    }

    static int distanceCheck(int start, int end) {
        int distance = 0;   // 실질적인 거리 차이 칸 수
        int difference = Math.abs(start - end); // 단순 거리 차이

        if (start == end) return distance;
        // 상하 거리 차이
        while (difference > 2) {
            difference -= 3;
            distance += 1;
        }
        // 좌우 거리 차이
        while (difference > 0) {
            difference -= 1;
            distance += 1;
        }
        return distance;
    }
}
