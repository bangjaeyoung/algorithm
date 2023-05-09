import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0].toLowerCase();
            String head2 = o2.split("[0-9]")[0].toLowerCase();
            if (head1.equals(head2)) {
                String rest1 = o1.substring(head1.length());
                String rest2 = o2.substring(head2.length());
                return Integer.parseInt(getNum(rest1)) - Integer.parseInt(getNum(rest2));
            } else {
                return head1.compareTo(head2);
            }
        });
        return files;
    }

    private String getNum(String rest) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rest.length(); i++) {
            char curChar = rest.charAt(i);
            if (Character.isDigit(curChar) && sb.length() <= 5) {
                sb.append(curChar);
            } else break;
        }
        return String.valueOf(sb);
    }
}