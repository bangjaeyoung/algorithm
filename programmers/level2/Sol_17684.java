package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
1. A ~ Z까지 사전에 등록 (초기화 작업)
2. LZW 압축 과정 진행
2-1. 인자로 받은 문자열을 하나씩 쪼개서 배열에 추가
2-2. 문제에 명시된 과정대로 진행 - 배열 순회하면서 사전에 있으면 출력 리스트에 색인 번호 추가, 없으면 사전에 새롭게 추가
3. 출력 리스트를 배열로 변환하여 정답 값으로 반환
 */
public class Sol_17684 {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = initializeDictionary();

        List<Integer> output = doLZWCompression(dictionary, msg);

        return output.stream().mapToInt(el -> el).toArray();
    }

    private Map<String, Integer> initializeDictionary() {
        Map<String, Integer> dictionary = new LinkedHashMap<>();

        for (int i = 1; i <= 26; i++)
            dictionary.put(String.valueOf((char) ('@' + i)), i);

        return dictionary;
    }

    private List<Integer> doLZWCompression(Map<String, Integer> dictionary, String msg) {
        List<Integer> output = new ArrayList<>();

        String[] msgArr = msg.split("");

        for (int i = 0; i < msgArr.length; ) {
            String currentInput;
            StringBuilder temp = new StringBuilder();
            int tempI = i;

            try {
                while (true) {
                    temp.append(msgArr[tempI]);

                    if (!dictionary.containsKey(String.valueOf(temp))) {
                        dictionary.put(String.valueOf(temp), dictionary.size() + 1);
                        temp.deleteCharAt(temp.length() - 1);
                        currentInput = String.valueOf(temp);
                        break;
                    }

                    tempI++;
                }

                output.add(dictionary.get(String.valueOf(currentInput)));

            } catch (ArrayIndexOutOfBoundsException e) {
                output.add(dictionary.get(String.valueOf(temp)));
                break;
            }

            i = tempI;
        }

        return output;
    }
}
