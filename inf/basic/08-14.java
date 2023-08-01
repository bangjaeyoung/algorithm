import java.io.*;
import java.util.*;
import java.util.stream.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Home extends Point {
    public Home(int x, int y) {
        super(x, y);
    }
}

class Pizza extends Point {
    public Pizza(int x, int y) {
        super(x, y);
    }
}

public class Main {
    static int n, m, pizzaSize, answer = Integer.MAX_VALUE;
    static int[][] city;
    static List<Home> homes = new ArrayList<>();
    static List<Pizza> pizzas = new ArrayList<>();
    static Integer[] combination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];
        combination = new Integer[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    homes.add(new Home(i, j));
                }

                if (city[i][j] == 2) {
                    pizzas.add(new Pizza(i, j));
                }
            }
        }

        pizzaSize = pizzas.size();
        comb(0, 0);
        System.out.print(answer);
    }

    private static void comb(int level, int start) {
        if (level == m) {
            answer = Math.min(answer, calculateDistance());
        } else {
            for (int i = start; i < pizzaSize; i++) {
                combination[level] = i;
                comb(level + 1, i + 1);
            }
        }
    }

    private static int calculateDistance() {
        List<Pizza> selectedPizzas = Arrays.stream(combination)
            .map(i -> pizzas.get(i))
            .collect(Collectors.toList());

        int sum = 0;
        for (Home home : homes) {
            int distance = Integer.MAX_VALUE;

            for(Pizza pizza : selectedPizzas) {
                distance = Math.min(distance, Math.abs(home.x - pizza.x) + Math.abs(home.y - pizza.y));
            }

            sum += distance;
        }

        return sum;
    }
}
