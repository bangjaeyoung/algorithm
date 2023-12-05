import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            boolean[] visited = new boolean[10_000];
            visited[A] = true;
            
            Queue<Register> queue = new LinkedList<>();
            queue.offer(new Register(A, ""));
            
            while (!queue.isEmpty()) {
                Register cur = queue.poll();
                
                if (cur.num == B) {
                    System.out.println(cur.command);
                    break;
                }
                
                if (!visited[cur.D()]) {
                    queue.offer(new Register(cur.D(), cur.command + "D"));
                    visited[cur.D()] = true;
                }
                
                if (!visited[cur.S()]) {
                    queue.offer(new Register(cur.S(), cur.command + "S"));
                    visited[cur.S()] = true;
                }
                
                if (!visited[cur.L()]) {
                    queue.offer(new Register(cur.L(), cur.command + "L"));
                    visited[cur.L()] = true;
                }
                
                if (!visited[cur.R()]) {
                    queue.offer(new Register(cur.R(), cur.command + "R"));
                    visited[cur.R()] = true;
                }
            }
        }
    }
    
    static class Register {
        int num;
        String command;
        
        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }
        
        int D() {
            return (num * 2) % 10_000;
        }
        
        int S() {
            return num == 0 ? 9_999 : num - 1;
        }
        
        int L() {
            return num % 1_000 * 10 + num / 1_000;
        }
        
        int R() {
            return num % 10 * 1_000 + num / 10;
        }
    }
}
