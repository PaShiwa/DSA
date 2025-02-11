package BinaryTree;
/*
Pre, In and Post order traversal are depth first search traversal.
Pre -> Root first and then left and right subtree
In -> Root in between Left and Right subtree
Post -> Root after the left and right subtree
 */

public class DFSTraversal {
    public static void preorder (Node node){
        // Base case
        if(node==null){
            return;
        }
        System.out.print(node.data + " ");
        // Recursively Traverse the left subtree
        preorder(node.left);
        // Recursively Traverse the right subtree
        preorder(node.right);
    }

    public static  void inorder(Node node){
        if (node==null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void postorder (Node node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Preorder Traversal: ");
        preorder(root);
        System.out.println();
        System.out.println("Inorder Traversal: ");
        inorder(root);
        System.out.println();
        System.out.println("Postorder Traversal: ");
        postorder(root);
    }

    /*
        1
       / \
      2   3   => 1 2 4 5 3
     / \
    4   5

     */
}
