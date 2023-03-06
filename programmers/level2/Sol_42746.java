package programmers.level2;

import java.util.Arrays;

/*
1. 인자로 받은 int 타입의 numbers 배열을 String 타입의 배열로 변환 (요소들을 모두 문자열 타입으로)
2. 생성된 문자열 배열에서 문자열 요소 2개씩 조합해보고, 내림차순으로 정렬
ex) "30" + "3" = "303" , "3" + "30" = "330"  ->  정렬하면 "3", "30" 순서
3. 새롭게 정렬된 문자열 배열에서 첫 요소가 0일 경우, 문자열 0을 반환. -> 0으로 시작하는 가장 큰 수는 0이므로
4. StringBuilder의 answer 인스턴스를 생성하고 문자열 배열의 요소를 하나씩 넣어 최종 answer을 문자열로 변환하여 반환
 */
public class Sol_42746 {
    public String solution(int[] numbers) {
        String[] strArr = Arrays.stream(numbers).boxed().map(String::valueOf).toArray(String[]::new);

        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strArr[0].equals("0")) return "0";

        StringBuilder answer = new StringBuilder();

        for (String str : strArr) {
            answer.append(str);
        }

        return String.valueOf(answer);
    }
}
