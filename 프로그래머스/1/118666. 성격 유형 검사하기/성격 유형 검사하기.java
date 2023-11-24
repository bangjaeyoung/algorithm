import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> score = new HashMap<>();
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            
            if (choices[i] == 1 || choices[i] == 2 || choices[i] == 3) {
                score.put(disagree, score.get(disagree) + (4 - choices[i]));
            }
            
            if (choices[i] == 5 || choices[i] == 6 || choices[i] == 7) {
                score.put(agree, score.get(agree) + (choices[i] - 4));
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        if (score.get('R') >= score.get('T')) {
            result.append('R');
        } else {
            result.append('T');
        }

        if (score.get('C') >= score.get('F')) {
            result.append('C');
        } else {
            result.append('F');
        }
        
        if (score.get('J') >= score.get('M')) {
            result.append('J');
        } else {
            result.append('M');
        }
        
        if (score.get('A') >= score.get('N')) {
            result.append('A');
        } else {
            result.append('N');
        }
        
        return result.toString();
    }
}
