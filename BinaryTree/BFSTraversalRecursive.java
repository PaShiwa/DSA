package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalRecursive {

    public static void levelOrder (Node root){
        if (root==null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println(current.data + " ");

            if(current.left!=null){
                queue.add(current.left);
            }

            if(current.right!=null){
                queue.add(current.right);
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Level-order Traversal: ");
        levelOrder(root);
    }
}
