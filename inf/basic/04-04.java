import java.util.*;

public class Main {
    public int solution(String s, String t) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray())
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        for (int i = 0; i < t.length()-1; i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        int lt = 0;
        for (int rt = t.length()-1; rt < s.length(); rt++) {
            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0)+1);
            if (map.equals(tMap))
                count++;
            map.put(s.charAt(lt), map.get(s.charAt(lt))-1);
            if (map.get(s.charAt(lt)) == 0)
                map.remove(s.charAt(lt));
            lt++;
        }
        return count;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.print(main.solution(s, t));
    }
}
