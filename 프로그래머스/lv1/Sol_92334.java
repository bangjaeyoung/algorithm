package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sol_92334 {
    public static int[] solution(String[] idList, String[] report, int k) {
        Map<String, Integer> reportList = new HashMap<>();
        for (String r : report) {
            reportList.put(r, 1);
        }
        System.out.println("reportList = " + reportList);
        System.out.println();

        Map<String, Integer> reporteeCnt = new HashMap<>();
        for (String key : reportList.keySet()) {
            String[] temp = key.split(" ");
            if (reporteeCnt.containsKey(temp[1])) {
                reporteeCnt.put(temp[1], reporteeCnt.get(temp[1]) + 1);
            } else reporteeCnt.put(temp[1], 1);
        }
        System.out.println("reporteeCnt = " + reporteeCnt);
        System.out.println();

        // {muzi, frodo, neo}
        // { 1,    2,     2 }
        int[] result = new int[idList.length];
        for (String key : reporteeCnt.keySet()) {
            if (reporteeCnt.get(key) >= k) {
                for (String ke : reportList.keySet()) {
                    String[] ex = ke.split(" ");
                    if (ex[1].equals(key)) {
                        result[Arrays.asList(idList).indexOf(ex[0])]++;
                    }

                }
                System.out.println("result = " + Arrays.toString(result));
            }
        }
        System.out.println();
        System.out.println("result = " + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        solution(idList, report, k);
    }
}
