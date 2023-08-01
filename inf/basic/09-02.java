import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting> {
    int startTime, endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting meeting) {
        if (this.endTime == meeting.endTime) {
            return this.startTime - meeting.startTime;
        } else {
            return this.endTime - meeting.endTime;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();

        StringTokenizer st;
        int startTime, endTime;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            startTime = Integer.parseInt(st.nextToken());
            endTime = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(startTime, endTime));
        }

        System.out.print(solution(meetings));
    }

    private static int solution(List<Meeting> meetings) {
        int answer = 0;
        int startTime = 0;

        Collections.sort(meetings);

        for (Meeting meeting : meetings) {
            if (meeting.startTime >= startTime) {
                startTime = meeting.endTime;
                answer++;
            }
        }

        return answer;
    }
}
