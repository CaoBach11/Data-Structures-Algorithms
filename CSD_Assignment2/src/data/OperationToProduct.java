package data;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class OperationToProduct {
    private static Scanner sc;
    private BufferedWriter outputFile;

    public OperationToProduct(Scanner console) {
        this.sc = console;
    }

    public OperationToProduct(Scanner sc, BufferedWriter outputFile) {
        this.sc = sc;
        this.outputFile = outputFile;
    }

    public static Product addProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        String idProduct = sc.next();
        sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String nameProduct = sc.nextLine();
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = sc.nextInt();
        System.out.print("Nhập giá sản phẩm: ");
        double price = sc.nextDouble();

        Product newProduct = new Product(idProduct, nameProduct, quantity, price);

        return newProduct;
    }

    /**
     * Đọc data từ file và add productus vào đuôi của linked list.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */
    public static void getAllItemsFromFile(String fileName, MyLinkedList<Product> list) {
        String thisLine;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while ((thisLine = br.readLine()) != null) {
                    String[] productInfo = thisLine.split(",");
                    Product newProduct = new Product(productInfo[0], productInfo[1],
                            Integer.parseInt(productInfo[2]), Double.parseDouble(productInfo[3]));
                    list.addToTail(newProduct);
                }
                br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Đọc data từ file và add productus vào stack.
     *
     * @param fileName The file name of the file
     * @param stack    The Stack contains all products that read from file
     */
    public static void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        String thisLine;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while ((thisLine = br.readLine()) != null) {
                System.out.println(thisLine);
                String[] productInfo = thisLine.split(",");
                Product newProduct = new Product(productInfo[0], productInfo[1],
                        Integer.parseInt(productInfo[2]), Double.parseDouble(productInfo[3]));
                stack.push(newProduct);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Đọc data từ file và add productus vào queue.
     *
     * @param fileName The file name of the file
     * @param queue    The Queue contains all products that read from file
     */
    public static void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        String thisLine;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            while ((thisLine = br.readLine()) != null) {
                String[] productInfo = thisLine.split(",");
                Product newProduct = new Product(productInfo[0], productInfo[1],
                        (int) Float.parseFloat(productInfo[2]), Float.parseFloat(productInfo[3]));
                queue.enQueue(newProduct);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ghi data từ linked list đến file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    public static void writeAllItemsToFile(String fileName, MyLinkedList<Product> list) {
        String thisline;
        try {
            FileWriter writer = new FileWriter(fileName, false);
            BufferedWriter buffer = new BufferedWriter(writer);
            Product newProduct;
            for (int i = 0; i < list.length(); i++) {
                 newProduct = list.getElementByIndex(i);
                thisline = newProduct.getIdProduct() + "," + newProduct.getNameProduct() + ","
                        + newProduct.getQuantity()+","+ newProduct.getPrice() + "\n";
                buffer.write(thisline);
            }
            buffer.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayAll(MyLinkedList<Product> list) {
        list.displayProductInfo();
    }

    public static void displayAll(MyStack<Product> myStack) {
        myStack.displayProductInfo();
    }

    public static void displayAll(MyQueue<Product> myQueue) {
        myQueue.displayProductInfo();
    }

    /**
     * Thêm data vào đầu linked list, thông tin data nhập từ bàn phím.
     *
     * @param list The Linked list
     */
    public static void addFirst(MyLinkedList<Product> list) {
        String input;
        do {
            Product product = addProduct();
            list.addToFront(product);
            System.out.println("Bạn có muốn tiếp tục(Y/N)");
            input = sc.next();
        } while (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("yes")
                || input.equalsIgnoreCase("y"));
    }

    /**
     * Thêm data vào đuôi linked list, thông tin data nhập từ bàn phím.
     *
     * @param list The Linked list
     */
    public static void addLast(MyLinkedList<Product> list) {
        String input;
        do {
            Product product = addProduct();
            list.addToTail(product);
            System.out.println("Bạn có muốn tiếp tục(Y/N)");
            input = sc.next();
        } while (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("yes")
                || input.equalsIgnoreCase("y"));
    }

    /**
     * Tìm data bằng ID, dữ liệu nhập từ bàn phím.
     *
     * @param list
     */
    public static void searchByCode(MyLinkedList<Product> list) {
        Node<Product> currentProduct = list.nodeHead;
        System.out.println("Search by ID: ");
        String searchID = sc.next();
        boolean search = false;
        while (currentProduct != null) {
            if (searchID.equalsIgnoreCase(currentProduct.info.getIdProduct())) {
                System.out.println("Product: ");
                System.out.println(currentProduct.info);
                search = true;
                break;
            } else {
                currentProduct = currentProduct.nodeNext;
            }
        }
        if (!search) {
            System.out.println("Not Found!!");
        }

    }

    /**
     * xóa data bằng ID, dữ liệu cần xóa nhập từ bàn phím.
     *
     * @param list
     */
    public static void deleteByCode(MyLinkedList<Product> list) {
        Node<Product> currentProduct = list.nodeHead;
        System.out.println("Delete by ID: ");
        String searchID = sc.next();
        boolean search = false;
        while (currentProduct != null) {
            if (searchID.equalsIgnoreCase(currentProduct.info.getIdProduct())) {
                list.deleteElement(currentProduct.info);
                System.out.println("Completed!!!!!!!!!!!!");
                search = true;
                break;
            }else if(searchID.equalsIgnoreCase(currentProduct.info.getIdProduct())) {
                list.deleteAtTail(currentProduct.info);
                System.out.println("Completed!!!!!!!!!!!!");
                search = true;
                break;
            }else{
                currentProduct = currentProduct.nodeNext;
            }
        }
        if (!search) {
            System.out.println("Not found");
        }
    }

    public static int convertToBinary(int i) {
        if (i == 0) {
            return 0;
        } else {
            return (i % 2 + 10 * convertToBinary(i / 2));
        }
    }

    public static void sortByCode(MyLinkedList<Product> list, Node<Product> start){
        if(list.isEmpty()){
            System.out.println("Empty!!!");
        }
        if(start.nodeNext == null){
            return;
        }
        Node<Product> min = start.nodeNext;
        while (min != null){
            if(start.info.getIdProduct().compareToIgnoreCase(min.info.getIdProduct()) > 0){
                list.swap(start,min);
            }
            min = min.nodeNext;
        }
        sortByCode(list,start.nodeNext);
    }
}

