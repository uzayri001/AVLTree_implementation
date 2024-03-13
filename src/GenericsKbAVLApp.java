import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class GenericsKbAVLApp {
    
    public static void main(String [] args) {
        AVLTree myAvlTree = new AVLTree();
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action from the menu: \n 1. Load a knowledge base from a file \n 2. Add a new statement to the knowledge base \n 3. Search for an item in the knowledge base by term \n 4. Search for a item in the knowledge base by term and sentence \n 5. Quit \n Enter your choice: \n");
            int input = kb.nextInt();
            kb.nextLine();
            if (input == 5) {break;}
        }
        kb.close();
    }
}
