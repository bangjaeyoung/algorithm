import java.util.*;
import java.io.*;


public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int pointsOfOneSide = 2;

        for (int i = 0; i < n; i++) {
            pointsOfOneSide *= 2;
            pointsOfOneSide--;
        }

        System.out.print(pointsOfOneSide * pointsOfOneSide);
    }
}
