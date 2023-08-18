import java.io.*;
import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, len, ans = Integer.MAX_VALUE;
    static int[] combi;
    static List<Point> houses, chickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());

                // 집일 경우
                if (now == 1) {
                    houses.add(new Point(i, j));
                }
                // 치킨집일 경우
                else if (now == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        len = chickens.size();
        combi = new int[M];
        dfs(0, 0);

        System.out.print(ans);
    }

    // 조합을 구하고 후처리하는 메서드
    private static void dfs(int level, int start) {
        if (level == M) {
            int sum = 0;

            // 각 집마다의 치킨 배달 거리를 구함
            for (Point house : houses) {
                int dis = Integer.MAX_VALUE;

                for (int comb : combi) {
                    dis = Math.min(dis,
                        Math.abs(house.x - chickens.get(comb).x) + Math.abs(house.y - chickens.get(comb).y));
                }

                sum += dis;
                
                if (sum > ans) return;
            }

            ans = Math.min(ans, sum);
        } else {
            for (int i = start; i < len; i++) {
                combi[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }
}
