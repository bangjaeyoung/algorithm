package programmers.level1;

class Sol_12954 {
    
    public long[] solution(int x, int n) {
      
        long[] answer = new long[n];
    
        long sum = 0;
        
        for(int i = 0; i < n; i++) {
            
            sum += x;
            answer[i] = sum;
        }
        
        return answer;
    }
}
