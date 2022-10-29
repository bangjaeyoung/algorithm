package programmers.level0;

public class Sol_120864 {
    public int solution(String my_string) {
        String[] onlyNums = my_string.toUpperCase().split("[A-Z]");
        int sum = 0;
        for (String n : onlyNums) {
            if (!n.equals("")) sum += Integer.parseInt(n);
        }
        return sum;
    }
}
