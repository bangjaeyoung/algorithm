package programmers.level0;

public class Sol_120869 {
    public int solution(String[] spell, String[] dic) {

        for (String d : dic) {
            int matchCount = 0;
            for (String s : spell) {
                if (d.contains(s)) matchCount++;
            }
            if (matchCount == spell.length) return 1;
        }
        return 2;
    }
}
