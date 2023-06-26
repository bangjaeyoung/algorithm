package programmers.level1;

public class Sol_131705 {
    public int solution(int[] number) {

        int firstNum;
        int secondNum;
        int thirdNum;

        int count = 0;

        for (int i = 0; i < number.length; i++) {
            firstNum = number[i];

            for (int j = i + 1; j < number.length; j++) {
                secondNum = number[j];

                for (int k = j + 1; k < number.length; k++) {
                    thirdNum = number[k];

                    if (firstNum + secondNum + thirdNum == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
