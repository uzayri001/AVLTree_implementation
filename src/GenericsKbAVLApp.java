import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GenericsKbAVLApp {
    public static void main(String [] args) {
        try (Scanner kb = new Scanner(System.in)) {
            AVLTree myAVLTree = new AVLTree();
            while (true) {
                System.out.println("Choose an action from the menu:\n 1. Load a knowledge base from a file \n 2. Load in a query file and search for terms \n 3. Quit and display count variables");
                System.out.print("Enter your choice: ");
                int input = kb.nextInt();
                kb.nextLine();
                if (input == 1) {
                    System.out.println("Enter the file name: ");
                    String fileName = kb.nextLine();
                    try {
                        File myFile = new File(fileName);
                        try (Scanner myScanner = new Scanner(myFile)) {
                            while (myScanner.hasNextLine()) {
                                String line = myScanner.nextLine(); 
                                Statements data = new Statements(line);
                                Node newNode = new Node(data);
                                myAVLTree.insert(newNode);       
                            }
                        }
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    }
                }

                else if (input == 2) {
                    System.out.println("Enter the file name: ");
                    String fileName = kb.nextLine();
                    try {
                        File myQueryFile = new File(fileName);
                        try (Scanner myScanner = new Scanner(myQueryFile)) {
                            while (myScanner.hasNextLine()) {
                                String term = myScanner.nextLine();
                                if (myAVLTree.searchByTerm(term) != null) {
                                    System.out.println(myAVLTree.searchByTerm(term));
                                }
                                else {System.out.printf("Term for %s is not in the knowledge base \n", term);}
                            }
                        }
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    }
                }
                
                else if (input == 3) {
                    try {
                        try (FileWriter myWriter = new FileWriter("Experiment.txt")) {
                            String insertCount = String.format("Insert count: %d \n",myAVLTree.insertCount);
                            String searchCount = String.format("Search count: %d \n",myAVLTree.searchCount);
                            myWriter.write(insertCount + searchCount);
                        }
                        break;
                    }
                    catch (IOException e) {System.out.println("Writing unsuccesful");}
                }     
            }
        }
    }
}