package programmers.level1;

class Sol_12912 {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a > b) {
            
            for(int i = 0; i < a - b + 1; i++) {
                answer += (b + i);
            }
            
        } else if(b > a) {
            
            for(int i = 0; i < b - a + 1; i++) {
                answer += (a + i);
            }
            
        }else {
            
            return a;
        }
        
        return answer;
    }
}
