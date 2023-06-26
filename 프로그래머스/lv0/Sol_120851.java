package 프로그래머스.lv0;

public class Sol_120851 {
    public int solution(String my_string) {

        int sum = 0;

        for (int i = 0; i < my_string.length(); i++) {
            try {
                String num = my_string.substring(i, i + 1);
                sum += Integer.parseInt(num);
            } catch (NumberFormatException e) {

            }
        }

        return sum;
    }
}
