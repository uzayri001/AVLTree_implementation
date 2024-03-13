/**
 * Node Class to be used for nodes in an AVL tree
 * contains a Statements object as data and a left, right child and a height variable
 * @author Uzayr Ismail
 * @version 2.0
 * @since 12/03/2024
 */

public class Node {
    Statements data;
    Node left;
    Node right;
    int height;

    public Node(Statements data) {
        this.data = data;
        height = 0;
    }
}
