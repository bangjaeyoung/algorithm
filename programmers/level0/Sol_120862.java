package programmers.level0;

public class Sol_120862 {
    public int solution(int[] numbers) {

        int multiply = numbers[0] * numbers[1];

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] * numbers[j] > multiply)
                    multiply = numbers[i] * numbers[j];
            }
        }

        return multiply;
    }
}
