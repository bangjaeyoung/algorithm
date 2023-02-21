package programmers.level2;

/*
1. skillTrees 배열을 순회하면서 하나의 skillTree를 비교한다.
2. 인자로 받은 skills에 포함되는 문자가 있으면 temp에 추가해준다.
3. 인자로 받은 skills를 첫 번째 문자부터 하나씩 붙여가며 temp와 비교해주고,
동일하다면 스킬 순서가 같은 것이므로 가능한 스킬 트리 순서 개수 1 증가
 */
public class Sol_49993 {
    public int solution(String skills, String[] skillTrees) {
        int answer = 0;

        for (String skillTree : skillTrees)
            if (checkPossibleSkillTrees(skills, skillTree)) answer++;

        return answer;
    }

    private boolean checkPossibleSkillTrees(String skills, String skillTree) {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < skillTree.length(); i++)
            if (skills.contains(String.valueOf(skillTree.charAt(i))))
                temp.append(skillTree.charAt(i));

        for (int i = 0; i <= skills.length(); i++) {
            String tempStr = skills.substring(0, i);

            if (tempStr.equals(String.valueOf(temp))) return true;
        }

        return false;
    }
}
