package programmers.level1;

public class Sol_142086 {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            String str = String.valueOf(s.charAt(i));

            if (temp.lastIndexOf(str) != -1) {
                result[i] = i - temp.lastIndexOf(str);
            } else result[i] = -1;

            temp.append(s.charAt(i));
        }

        return result;
    }
}
