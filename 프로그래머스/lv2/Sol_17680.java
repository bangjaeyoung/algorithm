package programmers.level2;

import java.util.*;

public class Sol_17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();

        if (cacheSize == 0) return cities.length * 5;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();

            if (list.contains(cities[i])) {
                answer++;
                list.remove(cities[i]);
                list.add(cities[i]);
            } else {
                answer += 5;

                if (list.size() == cacheSize) {
                    list.remove(0);
                    list.add(cities[i]);
                } else list.add(cities[i]);
            }
        }

        return answer;
    }
}
