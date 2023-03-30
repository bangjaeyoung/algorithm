import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];
        int[] strikeArr = new int[n];
        int[] ballArr = new int[n];
        StringTokenizer st;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            numArr[i] = Integer.parseInt(st.nextToken());
            strikeArr[i] = Integer.parseInt(st.nextToken());
            ballArr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        int check;
        int strike;
        int ball;
        int hundred1;
        int ten1;
        int one1;
        int hundred2;
        int ten2;
        int one2;
        
        for (int i = 123; i <= 987; i++) {
            hundred1 = i/100;
            ten1 = i/10%10;
            one1 = i%10;
            ball = 0;
            strike = 0;
            check = 0;
            
            if (i/100 == i/10%10) continue;
            if (i/100 == i%10) continue;
            if (i/10%10 == i%10) continue;
            if (i/10%10 == 0) continue;
            if (i%10 == 0) continue;
            
            for (int j = 0; j < n; j++) {
                hundred2 = numArr[j]/100;
                ten2 = numArr[j]/10%10;
                one2 = numArr[j]%10;
                strike = 0;
                ball = 0;
                
                if (hundred1 == hundred2) {
                    strike++;
                } else {
                    if (hundred1 == ten2) {
                        ball++;
                    }
                    if (hundred1 == one2) {
                        ball++;
                    }
                }
                
                if (ten1 == ten2) {
                    strike++;
                } else {
                    if (ten1 == hundred2) {
                        ball++;
                    }
                    if (ten1 == one2) {
                        ball++;
                    }
                }
                
                if (one1 == one2) {
                    strike++;
                } else {
                    if (one1 == hundred2) {
                        ball++;
                    }
                    if (one1 == ten2) {
                        ball++;
                    }
                }
                
                if (strike == strikeArr[j] && ball == ballArr[j]) check++;
                if (check == n) answer++;
            }
        }
        
        System.out.println(answer);
    }
}