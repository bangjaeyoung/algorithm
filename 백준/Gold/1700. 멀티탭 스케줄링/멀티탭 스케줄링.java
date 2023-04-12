import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        List<Integer> orders = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            orders.add(Integer.parseInt(st.nextToken()));
        }
        
        List<Integer> multitap = new ArrayList<>();
        int answer = 0;
        while (!orders.isEmpty()) {
            int order = orders.remove(0);
            if (multitap.contains(order)) continue;
            if (multitap.size() < n) {
                multitap.add(order);
            } else {
                boolean flag = false;
                int ordersIdx = -1;
                int multitapIdx = -1;
                answer++;
                for (int i = 0; i < multitap.size(); i++) {
                    if (!orders.contains(multitap.get(i))) {
                        flag = true;
                        multitap.remove(i);
                        multitap.add(order);
                        break;
                    } else {
                        if (orders.indexOf(multitap.get(i)) > ordersIdx) {
                            ordersIdx = orders.indexOf(multitap.get(i));
                            multitapIdx = i;
                        }
                    }
                }
                if (!flag) {
                    multitap.remove(multitapIdx);
                    multitap.add(order);
                }
            }
        }
        
        System.out.println(answer);
    }
}