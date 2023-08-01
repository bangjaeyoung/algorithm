import java.io.*;
import java.util.*;

class Time implements Comparable<Time> {
    int time;
    char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time time) {
        if (this.time == time.time) {
            return this.state - time.state;
        } else {
            return this.time - time.time;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Time> times = new ArrayList<>();

        StringTokenizer st;
        int startTime, endTime;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            startTime = Integer.parseInt(st.nextToken());
            times.add(new Time(startTime, 's'));

            endTime = Integer.parseInt(st.nextToken());
            times.add(new Time(endTime, 'e'));
        }

        System.out.print(solution(times));
    }

    private static int solution(List<Time> times) {
        int count = 0, answer = 0;

        Collections.sort(times);

        for (Time time : times) {
            if (time.state == 's') {
                count++;
            } else {
                count--;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
