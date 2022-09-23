package programmers.level1;

public class Sol_12916 {

    public static void main(String[] args) {

        String str = "Pyy";

        Solution solution = new Solution();

        System.out.println(solution.solution(str));
    }
}

class Solution {
    boolean solution(String s) {

        String str = s.toLowerCase();

        int countP = 0;
        int countY = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'p') {
                countP++;
            }
            if (str.charAt(i) == 'y') {
                countY++;
            }
        }

        return countP == countY;
    }
}
