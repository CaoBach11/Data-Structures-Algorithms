package data;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AS2_Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final String url = "src/data/";
    private static BufferedWriter bufferedWriter;
    private static OperationToProduct operation = new OperationToProduct(sc);
    private static MyLinkedList<Product> myList = new MyLinkedList();
    private static MyStack<Product> myStack = new MyStack();;
    private static MyQueue<Product> myQueue = new MyQueue();

    public static void main(String[] args) {
        String fileName = url + "data.txt";
        String consoleFileName = url+"console_output.txt";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(consoleFileName,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            operation = new OperationToProduct(sc, bufferedWriter);
        } catch (IOException e) {
            operation = new OperationToProduct(sc);
            fileWriter = null;
            bufferedWriter = null;
        }

        int choice;
        do {
            showMenu(consoleFileName);
            choice = sc.nextInt();
            chooseFunction(choice, fileName,consoleFileName);
        } while(choice > 0);

        System.out.println("Kết thúc chương trình");
        try {
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException|NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void showMenu(String printOutPut){
        String output = "\n"
                + "+------------------Menu----------------------+\n"
                + "|       Choose one of this options           |\n"
                + "|       Product list:                        |\n"
                + "|       1. Load data from file and display   |\n"
                + "|       2. Input & add to the end.           |\n"
                + "|       3. Display data of linked list       |\n"
                + "|       4. Save product list to file         |\n"
                + "|       5. Search product by ID              |\n"
                + "|       6. Delete product by ID              |\n"
                + "|       7. Sort by ID.                       |\n"
                + "|       8. Convert to Binary                 |\n"
                + "|       9. Load to stack and display.        |\n"
                + "|       10. Load to queue and display.       |\n"
                + "|       0. Exit                              |\n"
                + "|+-------------------------------------------+\n";
        consoleToFile(printOutPut, output, 2);
    }

    public static void chooseFunction(int choice, String fileName, String prinOutPut) {
        switch(choice) {
            case 1:
                String output = "List of products";
                consoleToFile(prinOutPut, output, 2);
                OperationToProduct.getAllItemsFromFile(fileName, myList);
                OperationToProduct.displayAll(myList);
                break;
            case 2:
                output = "Add new product";
                consoleToFile(prinOutPut, output, 2);
                OperationToProduct.addLast(myList);
                break;
            case 3:
                output = "Display data";
                consoleToFile(prinOutPut, output, 2);
                OperationToProduct.displayAll(myList);
                break;
            case 4:
                output = "Save product list to file";
                consoleToFile(prinOutPut, output, 2);
                OperationToProduct.writeAllItemsToFile(fileName, myList);
                break;
            case 5:
                OperationToProduct.searchByCode(myList);
                break;
            case 6:
                OperationToProduct.deleteByCode(myList);
                break;
            case 7:
                OperationToProduct.sortByCode(myList, myList.nodeHead);
                OperationToProduct.displayAll(myList);
                break;
            case 8:
                Node<Product> temp = myList.nodeHead;

                ArrayList temList;
                for(temList = new ArrayList(); temp != null; temp = temp.nodeNext) {
                    temList.add((temp.info).getQuantity());
                }

                for(int i = 0; i < temList.size(); ++i) {
                    PrintStream num = System.out;
                    Object binary = temList.get(i);
                    num.println(" Convert " + binary + " to " + OperationToProduct.convertToBinary((Integer)temList.get(i)));
                }
                return;
            case 9:
                output = "Load to stack and display";
                consoleToFile(prinOutPut, output, 2);
                OperationToProduct.getAllItemsFromFile(fileName, myStack);
                OperationToProduct.displayAll(myStack);
                break;
            case 10:
                output = "Load to queue and display";
                consoleToFile(prinOutPut, output, 2);
                OperationToProduct.getAllItemsFromFile(fileName, myQueue);
                OperationToProduct.displayAll(myQueue);
        }

    }
    /**
     * In console output to file
     * @param printOutPut
     * @param output
     * @param check
     */
    public static void consoleToFile(String printOutPut, String output, int check){
        try {
            File outputFile = new File(printOutPut);
            FileWriter writeData = new FileWriter(outputFile,true);
            if (check == 2){
                System.out.print(output + "\n");
            } else if (check == 1) {
                System.out.print(output);
            } else if (check == 0){}
            writeData.write(output + "\n");
            writeData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
