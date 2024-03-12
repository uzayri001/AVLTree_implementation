import java.util.Stack;

public class AVLTree {

    Node root;

    public int height(Node node) {
        if (node == null) {return -1;}
        else {
            return node.height;
        }
    }

    public Node rightRotation(Node y) {
        Node x = y.left;
        Node z = x.right;

        x.right = y;
        y.left = z;

        y.height = Math.max(height(y.left), height(y.right)) +1;
        x.height = Math.max(height(x.left), height(x.right)) +1;

        return x;
    }

    public Node leftRotation(Node x) {
        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;

        y.height = Math.max(height(y.left), height(y.right)) +1;
        x.height = Math.max(height(x.left), height(x.right)) +1;
        
        return y;
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return height(node.left) - height(node.right);
        }
    }



    public void preOrder() {
        if (root == null) {
            System.out.println("no nodes to print");
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.println(current.data);

            // Push right child first so left child is processed first (since stack is LIFO)
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void display() { displayHelper(root); }
    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public Node searchByTerm(int term) {return searchHelperByTerm(root, term);}
    private Node searchHelperByTerm(Node root, int term) {
        if (root == null) {return null;}
        else if (root.data == term) {return root;}
        else if (root.data < term) {return searchHelperByTerm(root.left, term);}
        else {return searchHelperByTerm(root.right, term);}
    }

    public void insert(Node node) { root = insertHelper(root, node); }
    private Node insertHelper(Node root, Node node) {
        int statement = node.data;
        if (root == null) {
            root = node;
            return root;
        }
        else if (statement < root.data ) {
            root.left = insertHelper(root.left, node);
        }
        else {
            root.right = insertHelper(root.right, node);
        }
        
        root.height = Math.max(height(root.left),height(root.right)) + 1;
        int balance = getBalance(root);

        if (balance > 1 && node.data < root.data) {
            return rightRotation(root);
        }
        else if (balance < -1 && node.data > root.data) {
            return leftRotation(root);
        }
        else if (balance >1 && node.data > root.data) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        else if (balance < -1 && node.data < root.data) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }
}
