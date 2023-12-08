import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            List<String> mbti = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            
            if (N > 32) {
                System.out.println(0);
                continue;
            }
            
            for (int student = 0; student < N; student++) {
                mbti.add(st.nextToken());
            }
            
            System.out.println(solve(N, mbti));
        }
    }
    
    private static int solve(int N, List<String> mbti) {
        int answer = Integer.MAX_VALUE;
        
        Loop:
        for (int i = 0; i < N - 2; i++) {
            String firstMbti = mbti.get(i);
            
            for (int j = i + 1; j < N - 1; j++) {
                String secondMbti = mbti.get(j);
                
                for (int k = j + 1; k < N; k++) {
                    int count = 0;
                    String thirdMbti = mbti.get(k);
                    
                    count += (countDifferentChars(firstMbti, secondMbti) + countDifferentChars(firstMbti, thirdMbti) + countDifferentChars(secondMbti, thirdMbti));
                    answer = Math.min(answer, count);
                    
                    if (answer == 0) break Loop;
                }
            }
        }
        
        return answer;
    }
    
    private static int countDifferentChars(String firstMbti, String secondMbti) {
        int count = 0;
        
        for (int i = 0; i < 4; i++) {
            if (firstMbti.charAt(i) != secondMbti.charAt(i)) {
                count++;
            }
        }
        
        return count;
    }
}
