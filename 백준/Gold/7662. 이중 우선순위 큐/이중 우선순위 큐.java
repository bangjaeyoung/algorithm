import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            
            for (int op = 0; op < k; op++) {
                st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                
                if (operation.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                }
                
                if (operation.equals("D")) {
                    if (treeMap.isEmpty()) continue;
                    
                    int target = num == -1 ? treeMap.firstKey() : treeMap.lastKey();
                    treeMap.put(target, treeMap.get(target) - 1);
                    if (treeMap.get(target) == 0) {
                        treeMap.remove(target);
                    }
                }
            }
            
            System.out.println(treeMap.isEmpty() ? "EMPTY" : treeMap.lastKey() + " " + treeMap.firstKey());
        }
    }
}
