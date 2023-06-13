import java.util.Scanner;

public class Main {
    public int solution(String str, char c) {
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        int count = 0;
        for (char a : str.toCharArray()) {
            if (a == c) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Main main = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        System.out.println(main.solution(str, c));
    }
}
