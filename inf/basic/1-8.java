import java.util.Scanner;

public class Main {
    public String solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String reverseStr = new StringBuilder(str).reverse().toString();
        
        if (str.equals(reverseStr)) {
            return "YES";
        }
      
        return "NO";
    }

    public static void main(String[] args) {
        Main main = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(main.solution(str));
    }
}
