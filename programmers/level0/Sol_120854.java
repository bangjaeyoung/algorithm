package programmers.level0;

public class Sol_120854 {
    public int[] solution(String[] strList) {

        int[] answer = new int[strList.length];

        for (int i = 0; i < strList.length; i++) {
            answer[i] = strList[i].length();
        }

        return answer;
    }
}
