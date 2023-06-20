import java.io.*;
import java.util.*;

public class Main {
    public static List<String> a = new ArrayList<>();
    public static List<String> b = new ArrayList<>();

    public String solution(int index) {
        String currentA = a.get(index);
        String currentB = b.get(index);

        if (currentA.equals(currentB)) {
            return "D";
        } else if (currentA.equals("1") && currentB.equals("3")) {
            return "A";
        } else if (currentA.equals("2") && currentB.equals("1")) {
            return "A";
        } else if (currentA.equals("3") && currentB.equals("2")) {
            return "A";
        } else {
            return "B";
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            a.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            b.add(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            System.out.println(main.solution(i));
        }
    }
}
