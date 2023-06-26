package programmers.level2;

public class Sol_70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int toBinaryCount = 0;
        int removedZeroCount = 0;

        while (!s.equals("1")) {
            removedZeroCount += s.length();
            s = s.replaceAll("0", "");
            removedZeroCount -= s.length();

            s = Integer.toBinaryString(s.length());
            toBinaryCount++;
        }

        answer[0] = toBinaryCount;
        answer[1] = removedZeroCount;

        return answer;
    }
}
