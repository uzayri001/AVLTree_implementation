public class GenericsKbAVLApp {
    
    public static void main(String [] args) {
        AVLTree myAvlTree = new AVLTree();
        myAvlTree.insert(new Node(10));
        myAvlTree.insert(new Node(20));
        myAvlTree.insert(new Node(7));
        myAvlTree.insert(new Node(25));
        myAvlTree.insert(new Node(15));
        myAvlTree.insert(new Node(2));
        myAvlTree.insert(new Node(8));
        myAvlTree.display();
    }
}
