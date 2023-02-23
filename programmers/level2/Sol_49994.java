package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class Sol_49994 {
    public int solution(String dirs) {
        Set<String> s = new HashSet<>();

        int curX = 0;
        int curY = 0;

        for (int i = 0; i < dirs.length(); i++) {
            int nextX = curX;
            int nextY = curY;

            char dir = dirs.charAt(i);
            StringBuilder road = new StringBuilder();

            switch (dir) {
                case 'U':
                    nextY++;
                    road.append(curX);
                    road.append(curY);
                    road.append(nextX);
                    road.append(nextY);
                    break;
                case 'D':
                    nextY--;
                    road.append(nextX);
                    road.append(nextY);
                    road.append(curX);
                    road.append(curY);
                    break;
                case 'R':
                    nextX++;
                    road.append(curX);
                    road.append(curY);
                    road.append(nextX);
                    road.append(nextY);
                    break;
                case 'L':
                    nextX--;
                    road.append(nextX);
                    road.append(nextY);
                    road.append(curX);
                    road.append(curY);
                    break;
            }

            if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5) continue;

            s.add(String.valueOf(road));

            curX = nextX;
            curY = nextY;
        }

        return s.size();
    }
}
