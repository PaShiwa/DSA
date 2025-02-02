import java.util.Stack;

public class BFSTraversalIterative {

    static void iterativePreorder(Node root){
        if (root==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right!=null){
                stack.push(current.right);
            }

            if (current.left!=null){
                stack.push(current.left);
            }
        }
    }

    static void iterativeInOrder(Node root){
        if (root==null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(!stack.isEmpty() || current!=null){
            // Go as left as possible
            while (current!=null){
                stack.push(current);
                current = current.left;
            }

            current=stack.pop();
            System.out.print(current.data + " ");

            current = current.right;
        }
    }

    static void iterativePostOrder(Node root){
        if(root==null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while(!stack1.isEmpty()){
            Node current = stack1.pop();
            stack2.push(current);

            if(current.left!=null){
                stack1.push(current.left);
            }

            if(current.right!=null){
                stack1.push(current.right);
            }
        }

        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data+ " ");
        }
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println("Iterative Preorder Traversal:");
        iterativePreorder(root);
        System.out.println();

        System.out.println("Iterative Inorder Traversal:");
        iterativeInOrder(root);
        System.out.println();

        System.out.println("Iterative Postorder Traversal:");
        iterativePostOrder(root);
    }

}
