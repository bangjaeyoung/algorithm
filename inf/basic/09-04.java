import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {
    public int money, day;

    public Lecture(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture lecture) {
        return lecture.day - this.day;
    }
}

public class Main {
    static int n, maxDay = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();

        StringTokenizer st;
        int money, day;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            money = Integer.parseInt(st.nextToken());
            day = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(money, day));

            if (day > maxDay)
                maxDay = day;
        }

        System.out.print(solution(lectures));
    }

    private static int solution(List<Lecture> lectures) {
        int answer = 0;
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        Collections.sort(lectures);

        int j = 0;
        for (int i = maxDay; i >= 1; i--) {
            for ( ; j < n; j++) {
                if (lectures.get(j).day < i)
                    break;
                else pQ.offer(lectures.get(j).money);
            }
            
            if (!pQ.isEmpty())
                answer += pQ.poll();
        }

        return answer;
    }
}
