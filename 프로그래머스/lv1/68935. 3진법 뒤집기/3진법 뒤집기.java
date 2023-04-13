class Solution {
    public int solution(int n) {
        // 10 -> 3
        String three = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder();
        for (int i = three.length() - 1; i >= 0; i--) {
            sb.append(three.charAt(i));
        }
        // 3 -> 10
        return Integer.parseInt(String.valueOf(sb), 3);
    }
}