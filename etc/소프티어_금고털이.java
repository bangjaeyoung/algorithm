import java.util.*;
import java.io.*;

class Jewel implements Comparable<Jewel> {
    int weight, price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel jewel) {
        if (jewel.price == this.price) {
            return this.weight - jewel.weight;
        } else {
            return jewel.price - this.price;
        }
    }
}

public class Main {
    static int totalWeight, n;
    static List<Jewel> jewels = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        totalWeight = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(weight, price));
        }

        System.out.print(solution());
    }

    private static int solution() {
        int answer = 0;

        Collections.sort(jewels);

        for (Jewel jewel : jewels) {
            if (jewel.weight < totalWeight) {
                answer += jewel.weight * jewel.price;
                totalWeight -= jewel.weight;
            } else {
                answer += totalWeight * jewel.price;
                break;
            }
        }

        return answer;
    }
}
