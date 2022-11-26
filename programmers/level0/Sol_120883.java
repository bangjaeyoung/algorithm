package programmers.level0;

import java.util.*;

public class Sol_120883 {
    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> dbMap = new HashMap<>();

        for (String[] account : db) {
            dbMap.put(account[0], account[1]);
        }

        if (dbMap.containsKey(id_pw[0])) {
            if (dbMap.get(id_pw[0]).equals(id_pw[1])) return "login";
            else return "wrong pw";
        } else return "fail";
    }
}
