package programmers.level0;

public class Sol_120888 {
    public String solution(String my_string) {

        StringBuilder answer = new StringBuilder();
        char[] myStringCharArr = my_string.toCharArray();

        for (char myString : myStringCharArr) {
            if (!String.valueOf(answer).contains(String.valueOf(myString))) answer.append(myString);
        }

        return String.valueOf(answer);
    }
}
