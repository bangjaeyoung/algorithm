import java.io.*;
import java.util.*;

class Brick implements Comparable<Brick> {
  int size, height, weight;
  
  public Brick(int size, int height, int weight) {
    this.size = size;
    this.height = height;
    this.weight = weight;
  }
  
  @Override
  public int compareTo(Brick brick) {
    return brick.size - this.size;
  }
}

public class Main {
  static List<Brick> bricks = new ArrayList<>();
  static int[] dy;
  static int n;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    
    dy = new int[n];
    
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int size = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      
      bricks.add(new Brick(size, height, weight));
    }
    
    System.out.print(solution());
  }
  
  public static int solution() {
    Collections.sort(bricks);
    
    dy[0] = bricks.get(0).height;
    int answer = dy[0];
    
    for (int i = 1; i < n; i++) {
      int max = 0;
      
      for (int j = 0; j <= i-1; j++) {
        if (bricks.get(i).weight < bricks.get(j).weight && dy[j] > max) {
          max = dy[j];
        }
      }
      
      dy[i] = max + bricks.get(i).height;
      answer = Math.max(answer, dy[i]);
    }
    
    return answer;
  }
}
