import java.io.*;
import java.util.*;

class Body implements Comparable<Body> {
  int height, weight;

  public Body(int height, int weight) {
    this.height = height;
    this.weight = weight;
  }

  @Override
  public int compareTo(Body body) {
    return body.height - this.height;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Body> bodies = new ArrayList<>();
    
    StringTokenizer st;
    int height, weight;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      height = Integer.parseInt(st.nextToken());
      weight = Integer.parseInt(st.nextToken());
      bodies.add(new Body(height, weight));
    }

    System.out.print(solution(bodies));
  }

  private static int solution(List<Body> bodies) {
    int answer = 0;
    int maxWeight = Integer.MIN_VALUE;

    Collections.sort(bodies);

    for (Body body : bodies) {
      if (body.weight > maxWeight) {
        maxWeight = body.weight;
        answer++;
      }
    }

    return answer;
  }
}
