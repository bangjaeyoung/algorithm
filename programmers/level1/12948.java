class Solution {
    public String solution(String phone_number) {
        StringBuilder builder = new StringBuilder(phone_number);
        
        for(int i = 0; i < phone_number.length()-4; i++) {
            builder.setCharAt(i, '*');
        }
        
        return builder.toString();
    }
}
