package Assignment1;

import java.io.File;
import java.util.Scanner;

public class Main_sort {
    private static final Algorithm algorithm = new Algorithm();
    private static final Scanner sc = new Scanner(System.in);
    private static String url = "src/Assignment1/";
    private static float[] arr;

    public static void main(String[] args) {
        int choice ;
        do {
            menu();
            choice = sc.nextInt();
            function(choice);
            algorithm.displayTimeRunSecond();

        } while (choice != 0);
        System.out.println("Kết thúc chương trình");

    }

    /**
     * In menu
     */
    public static void menu(){
        System.out.println("+--------------Menu-------------+");
        System.out.println("|      	1.Input                 |");
        System.out.println("|      	2.Output                |");
        System.out.println("|      	3.Bubble sort           |");
        System.out.println("|      	4.Selection sort        |");
        System.out.println("|      	5.Insertion sort        |");
        System.out.println("|      	6.Search > value        |");
        System.out.println("|      	7.Search = value        |");
        System.out.println("|      	0.Exit                  |");
        System.out.println("+-------------------------------+");
        System.out.print("Vui lòng nhập (0-7): ");
    }

    /**
     * Chức năng của chương trình
     * @param choice nhập từ user
     */

    public static void function(int choice){
            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    bubbleSort();
                    break;
                case 4:
                    selectionSort();
                    break;
                case 5:
                    insertionSort();
                    break;
                case 6:
                    linearSearch();
                    break;
                case 7:
                    binarySearch();
                    break;
            }
    }

    /**
     * Nhập số lượng phần tử từ user
     */

    public static void input() {
        String fileName = url + "INPUT.TXT";
        System.out.print("Số lượng phần tử trong mảng: ");
        int number = sc.nextInt();
        arr = new float[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Phần tử "+(i+1)+": ");
            arr[i] = sc.nextFloat();
        }
        algorithm.writeFile(fileName,arr);
    }

    /**
     * In mảng chứa phần tử sau khi nhập
     */

    public static void output() {
        String fileName = url + "INPUT.TXT";
        algorithm.readFile(fileName);
        System.out.print("Mảng bao gồm: ");
        algorithm.display(arr);
    }

    /**
     * Sắp xếp mảng bằng thuật tuán Bubble Sort
     */

    public static void bubbleSort(){
        String fileName1 = url + "OUTPUT1.TXT";
        System.out.println("Bubble Sort");
        float[] result = algorithm.bubbleSort(arr);
        algorithm.writeFile(fileName1,result);
    }
    /**
     * Sắp xếp mảng bằng thuật tuán Selection Sort
     */

    public static void selectionSort() {
        String fileName2 = url + "OUTPUT2.TXT";
        System.out.println("Selection sort");
        float[] result = algorithm.selectionSort(arr);
        algorithm.writeFile(fileName2,result);
    }
    /**
     * Sắp xếp mảng bằng thuật tuán Insertion Sort
     */

    public static void insertionSort() {
        String fileName3 = url + "OUTPUT3.TXT";
        System.out.println("Insertion sort");
        float[] result = algorithm.insertionSort(arr);
        algorithm.writeFile(fileName3,result);
    }

    /**
     * Tìm kiếm phần tử bằng thuật toán tìm kiếm tuyến tính
     */

    public static void linearSearch(){
        String fileName = url + "OUTPUT4.TXT";
        System.out.println("Linear Search");
        System.out.print("Nhập giá trị: ");
        float number = sc.nextFloat();
        int[] result = algorithm.linearSearch(arr,number);
        if (result.length <= 20) {
            System.out.print("Phẩn tử lớn hơn số " + number + " : ");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
        } else {
            System.out.print("Phần tử lớn hơn số " + number + " : "+result.length);
        }
        System.out.println();

        algorithm.writeFile(fileName,result);
    }

    /**
     * Tìm kiếm phần tử bằng thuật toán tìm kiếm nhị phân
     */

    public static void binarySearch(){
        String fileName5 = url + "OUTPUT5.TXT";
        System.out.println("Binary Search");
        System.out.print("Nhập giá trị: ");
        float number = sc.nextFloat();
        int result = algorithm.binarySearch(arr,number);
        System.out.print("Phần tử cần tìm: ");
        System.out.println(result);
        algorithm.writeFile(fileName5,result);
    }

}

