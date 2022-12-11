package programmers.level1;

public class Sol_133502 {
    public static int solution(int[] ingredient) {
        StringBuilder ingredients = new StringBuilder();
        int hamburgerCnt = 0;
        for (int i : ingredient) {
            ingredients.append(i);
            if (ingredients.length() > 3 && ingredients.subSequence(ingredients.length() - 4, ingredients.length()).equals("1231")) {
                hamburgerCnt++;
                ingredients.delete(ingredients.length() - 4, ingredients.length());
            }
        }
        return hamburgerCnt;
    }
}
