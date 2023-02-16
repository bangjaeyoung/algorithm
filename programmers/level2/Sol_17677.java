package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 1. str1, str2 모두 대문자로 변환한다.
 * 2. str1, str2의 다중 집합 리스트를 구한다.
 * 공백, 숫자, 특수 문자가 들어있는 다중 집합은 삭제한다.
 * 3. 여기서, str1와 str2의 리스트 사이즈가 0일 경우,
 * 나눗셈 즉 자카드 유사도를 구할 수 없기 때문에, 즉시 65536을 반환한다.
 * 4. 두 리스트의 교집합과 합집합 리스트를 구한다.
 * 5. 구한 교집합, 합집합 리스트로 자카드 유사도를 구한다.
 **/

public class Sol_17677 {
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> str1List = removeUnnecessarySets(makeMultipleSets(str1));
        List<String> str2List = removeUnnecessarySets(makeMultipleSets(str2));

        if (str1List.size() == 0 && str2List.size() == 0) return 65536;

        List<String> intersectionList = makeIntersectionList(str1List, str2List);
        List<String> unionList = makeUnionList(str1List, str2List);

        double jaccardSimilarity = calculateJaccardSimilarity(intersectionList, unionList);

        int answer = (int) (jaccardSimilarity * 65536);

        return answer;
    }

    private static List<String> makeMultipleSets(String str) {
        List<String> multipleSets = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            try {
                multipleSets.add(str.substring(i, i + 2));
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }

        return multipleSets;
    }

    private static List<String> removeUnnecessarySets(List<String> multipleSets) {
        List<String> completedMultipleSets = multipleSets.stream()
                .map(el -> el.replaceAll("[^A-Z]", ""))
                .filter(el -> el.length() == 2)
                .collect(Collectors.toList());

        return completedMultipleSets;
    }

    private static List<String> makeIntersectionList(List<String> str1List, List<String> str2List) {
        List<String> intersectionList = str1List.stream()
                .filter(el -> str2List.stream().anyMatch(Predicate.isEqual(el)))
                .collect(Collectors.toList());

        return intersectionList;
    }

    private static List<String> makeUnionList(List<String> str1List, List<String> str2List) {
        str1List.removeAll(str2List);

        List<String> unionList = new ArrayList<>();
        unionList.addAll(str1List);
        unionList.addAll(str2List);

        return unionList;
    }

    private static double calculateJaccardSimilarity(List<String> intersectionList, List<String> unionList) {
        double sizeOfIntersectionList = intersectionList.size();
        double sizeOfConsolidatedList = unionList.size();

        double jaccardSimilarity = sizeOfIntersectionList / sizeOfConsolidatedList;

        return jaccardSimilarity;
    }

    public static void main(String[] args) {
        String str1 = "abab";
        String str2 = "baba";
        System.out.println("solution(str1, str2) = " + solution(str1, str2));
    }
}
