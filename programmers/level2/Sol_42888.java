package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
1. Key를 유저 아이디, Value를 유저 닉네임으로 가지는 Map을 생성
유저 아이디는 중복될 수 없고, 변하지 않는 유저 아이디와는 별개로 유저 닉네임은 변할 수 있기 때문에 각각 Key, Value로 설정
유저 정보를 담는 Map을 먼저 생성해주는 이유는 최종으로 확정된 유저 닉네임을 미리 알고, 후에 간편하게 사용할 수 있기 때문
2. 이제 인자로 받은 records 배열을 순회하면서, action에 따른 상태 메시지를 정답 리스트에 추가
3. 정답 리스트를 배열로 변환하면 반환
 */
public class Sol_42888 {
    public String[] solution(String[] records) {
        List<String> answer = new ArrayList<>();

        Map<String, String> userInfo = getUserInfo(records);

        for (String el : records) {
            String[] record = el.split(" ");

            String action = record[0];
            String userId = record[1];

            switch (action) {
                case "Enter":
                    answer.add(userInfo.get(userId) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(userInfo.get(userId) + "님이 나갔습니다.");
                    break;
            }
        }

        return answer.toArray(new String[0]);
    }

    private Map<String, String> getUserInfo(String[] records) {
        Map<String, String> userInfo = new LinkedHashMap<>();

        for (String el : records) {
            String[] record = el.split(" ");

            String action = record[0];
            if (action.equals("Leave")) continue;

            String userId = record[1];
            String nickname = record[2];

            userInfo.put(userId, nickname);
        }

        return userInfo;
    }
}
