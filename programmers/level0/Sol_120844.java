package programmers.level0;

public class Sol_120844 {
    public int[] solution(int[] numbers, String direction) {

        int[] answer = new int[numbers.length];

        switch (direction) {
            case "right":
                answer[0] = numbers[numbers.length - 1];
                System.arraycopy(numbers, 0, answer, 1, numbers.length - 1);
                break;

            case "left":
                answer[numbers.length - 1] = numbers[0];
                System.arraycopy(numbers, 1, answer, 0, numbers.length - 1);
                break;
        }

        return answer;
    }
}
