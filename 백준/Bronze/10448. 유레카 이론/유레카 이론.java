import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int answer = 0;

            outLoop :
            for (int j = 1; j <= num / 2; j++) {
                for (int k = 1; k <= num / 2; k++) {
                    for (int l = 1; l <= num / 2; l++) {
                        if (num == j*(j+1)/2 + k*(k+1)/2 + l*(l+1)/2) {
                            answer = 1;
                            System.out.println(answer);
                            break outLoop;
                        }
                    }
                }
            }
            
            if (answer == 0) {
                System.out.println(answer);
            }
        }
    }
}