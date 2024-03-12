public class GenericsKbAVLApp {
    
    public static void main(String [] args) {
        AVLTree myAvlTree = new AVLTree();
        myAvlTree.insert(new Node(5));
        myAvlTree.insert(new Node(2));
        myAvlTree.insert(new Node(7));
        myAvlTree.insert(new Node(1));
        myAvlTree.insert(new Node(4));
        myAvlTree.insert(new Node(6));
        myAvlTree.insert(new Node(15));
        myAvlTree.insert(new Node(3));
        myAvlTree.insert(new Node(9));
        myAvlTree.insert(new Node(16));
        myAvlTree.preOrder();
    }
}
