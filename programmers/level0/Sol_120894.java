package programmers.level0;

public class Sol_120894 {
    public long solution(String numbers) {
        String[] engNums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < engNums.length; i++) {
            numbers = numbers.replaceAll(engNums[i], String.valueOf(i));
        }
        return Long.parseLong(numbers);
    }
}
