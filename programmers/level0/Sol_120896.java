package programmers.level0;

public class Sol_120896 {
    public String solution(String s) {

        int[] alphabetCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabetCount[s.charAt(i) - 97]++;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < alphabetCount.length; i++) {
            if (alphabetCount[i] == 1) result.append((char) (i + 97));
        }

        return String.valueOf(result);
    }
}
