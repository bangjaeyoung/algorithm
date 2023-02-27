package programmers.level2;

import java.util.HashMap;
import java.util.Map;

/*
1. 실제 전화번호부처럼 전화번호와 인덱스 값을 key, value 형태로 HashMap에 넣어준다.
2. phoneBook 배열을 순회하는데, 각 요소를 substring으로 쪼개어 접두어인지 비교해간다.
*** key가 "119"인 것과 phoneBook의 요소 "119"인 것과 비교를 하나??
*** 아니다. substring(0, 문자열 길이 - 1)를 해주게 되면, 항상 본래 문자열보다 하나 적은 문자열까지 비교하기 때문에,
*** phoneBook의 요소 "119"에서 "11"이 될 때까지만 substring을 해주고, key 목록에 포함되는지를 확인한다.
*** 즉, 한 번호가 자기 자신의 번호가 아닌, 다른 번호와 비교된다.
 */
public class Sol_42577 {
    public boolean solution(String[] phoneBook) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++)
            map.put(phoneBook[i], i);

        for (String phoneNum : phoneBook)
            for (int i = 0; i < phoneNum.length(); i++)
                if (map.containsKey(phoneNum.substring(0, i))) return false;

        return true;
    }
}
