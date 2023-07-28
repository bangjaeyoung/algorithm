import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        this.lt = this.rt = null;
    }
}

public class Main {
    Node root;

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.bfs(tree.root);
    }

    private void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(depth + " : ");

            for (int i = 0; i < len; i++) {
                Node curNode = queue.poll();
                System.out.print(curNode.data + " ");

                if (curNode.lt != null) queue.offer(curNode.lt);
                if (curNode.rt != null) queue.offer(curNode.rt);
            }

            depth++;
            System.out.println();
        }
    }
}
