package programmers.level1;

public class Sol_12947 {

    public boolean solution(int x) {

        String str = String.valueOf(x);

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - '0');
        }

        return x % sum == 0;
    }
}
