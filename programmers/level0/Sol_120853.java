package programmers.level0;

import java.util.Stack;

public class Sol_120853 {
    public int solution(String s) {
        String[] sArr = s.split(" ");
        Stack<String> nums = new Stack<>();

        for (String str : sArr) {
            nums.push(str);
            if (str.equals("Z")) {
                nums.pop();
                nums.pop();
            }
        }
        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }
        return result;
    }
}
