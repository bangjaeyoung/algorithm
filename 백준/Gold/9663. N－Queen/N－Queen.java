import java.util.*;
import java.io.*;

public class Main {
    static int n, count = 0;
    static int[] rowNumsOfColumn;    // 각 열의 행 번호를 담은 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rowNumsOfColumn = new int[n];
        
        nQueen(0);
        
        System.out.print(count);
    }
    
    public static void nQueen(int column) {
        if (column == n) {
            count++;
            return;
        } else {
            for (int i=0; i<n; i++) {
                rowNumsOfColumn[column] = i;
                
                // 다음 열에서 퀸이 놓일 수 있는 행 번호를 찾고, 다음 열 진행
                if (isPossible(column)) {
                    nQueen(column+1);
                }
            }
        }
    }
    
    public static boolean isPossible(int column) {
        for (int i=0; i<column; i++) {
            // 같은 행에 놓여있다면 false
            if (rowNumsOfColumn[i] == rowNumsOfColumn[column]) {
                return false;
            }
            // 대각선에 놓여있다면 false (행 번호끼리의 차와 열 번호끼리의 차가 같다면 대각선 위치에 놓인 것)
            else if ((column-i) == Math.abs(rowNumsOfColumn[i]-rowNumsOfColumn[column])) {
                return false;
            }
        }
        
        return true;
    }
}
