public class AVLTree {

    Node root;

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
        return root;
    }
}
