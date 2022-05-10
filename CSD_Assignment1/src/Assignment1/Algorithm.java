package Assignment1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algorithm {
    private long startTime = System.nanoTime();
    private long endTime = System.nanoTime();

    /**
     * Tạo hàm displayTimeRunSecond để tính
     * thời gian chạy của các thuật toán
     */
    public void displayTimeRunSecond() {
        double duration = (endTime - startTime)/1000000000.0; //divide by 1000000 to get milliseconds.
        System.out.printf("Chương trình chạy mất %.2f giây\n",duration);
    }

    /**
     * Ghi file của mảng từ dữ liệu đầu vào của arr
     * @param fileName để lưu dữ liệu của file sau khi viết
     * @param arr dữ liệu đầu vào của mảng
     */
    public  void writeFile(String fileName, float[] arr) {
        String[] temp = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = String.valueOf(arr[i]);
        }
        writeFile(fileName,temp);
    }
    public  void writeFile(String fileName, int[] arr) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (int i = 0; i < arr.length; i++) {
                fileWriter.write(String.valueOf(arr[i]) + " ");
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Lưu Thành Công");
        }

    }

    public void writeFile(String fileName, String[] arr) {
        try {
            FileWriter fout = new FileWriter (fileName);
            BufferedWriter bw = new BufferedWriter (fout);

            for(int x = 0; x < arr.length ; x++) {
                bw.write(arr[x]+" ");
            }
            bw.close();
            fout.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
    public  void writeFile(String fileName, int num) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(num) + " ");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Lưu Thành Công");
        }
    }

    /**
     * Đọc file của mảng từ dữ liệu đầu vào
     * @param fileName để đọc mảng arr
     */
    public  float[] readFile(String fileName) {
        List<Float> arr = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Lưu Thành Công");
        }
        float [] result = new float[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }

    /**
     * Tạo hàm swap để đổi vị trí của 2 phần tử trong mảng
     * @param arr dữ liệu đầu vào để swap
     * @param i phần tử thứ nhất
     * @param j phẩn tử thứ hai
     */
    public float[] swap(float[] arr, int i, int j) {
        float x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;

        return arr;
    }

    /**
     * Hiển thị mảng ra console
     * @param arr dữ liệu đầu vào để in ra
     */
    public  void display(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Sắp xếp các phần tử trong mảng theo thuật toán Bubble Sort
     * @param arr mảng được dùng để sắp xếp thuật toán
     * @return trả về dữ liệu sau khi sắp xếp
     */
    public float[] bubbleSort(float arr[]) {
        startTime = System.nanoTime();
        float [] temp = arr.clone();
        System.out.print("Array: ");
        display(temp);
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = 0; j < temp.length -1 - i ; j++) {
                if (temp[j] > temp[j + 1]) {
                    swap(temp,j,j+1);

                }
            }
            display(temp);
        }
        System.out.print("Mảng sau khi sắp xếp: ");
        display(temp);
        endTime = System.nanoTime();
        return temp;
    }

    /**
     * Sắp xếp các phần tử trong mảng theo thuật toán Selection Sort
     * @param arr mảng được dùng để sắp xếp thuật toán
     * @return trả về dữ liệu sau khi sắp xếp
     */
    public float[] selectionSort(float arr[]) {
        startTime = System.nanoTime();
        float[] temp = arr.clone();
        float min;
        int minIndex;
        System.out.print("Array: ");
        display(temp);
        for (int i = 0; i < temp.length - 1; i++) {
             min = temp[i];
             minIndex = i;
            for (int j = i + 1; j < temp.length; j++) {
                if (min > temp[j]) {
                    min = temp[j];
                    minIndex = j;
                    swap(temp,i,minIndex);
                }
            }
            display(temp);
        }
        System.out.print("Mảng sau khi sắp xếp: ");
        display(temp);
        endTime = System.nanoTime();
        return temp;
    }

    /**
     * Sắp xếp các phần tử trong mảng theo thuật toán Insertion Sort
     * @param arr mảng được dùng để sắp xếp thuật toán
     * @return trả về dữ liệu sau khi sắp xếp
     */
    public float[] insertionSort(float arr[]) {
        startTime = System.nanoTime();
        float[] temp = arr.clone();
        for (int i = 0; i < temp.length; i++) {
            float t = temp[i];
            int j = i - 1;
            while (j >= 0 && t < temp[j]) {
                temp[j + 1] = temp[j];
                j--;
            }
            temp[j + 1] = t;
            this.display(temp);
        }
        System.out.print("Mảng sau khi sắp xếp: ");
        display(temp);
        endTime = System.nanoTime();
        return temp;
    }

    /**
     * Sử dụng thuật toán tìm kiếm tuyến tính, tìm kiếm vị trí của các phần tử có giá trị lớn hơn biến nhập vào, hiển
     * thị ra màn hình và lưu vào file OUTPUT4.TXT
     * @param arr mảng dùng để tìm kiếm tuyến tính
     * @param number biến dùng để nhập phần tử cần tìm
     * @return trả về vị trí phần tử có kết quả lớn hơn biến nhập vào, nếu không lớn hơn trả về -1
     */
    public int[] linearSearch(float arr[], float number) {
        startTime = System.nanoTime();
        float[] temp = arr.clone();
        List<Integer> listIndex = new ArrayList<>();
        int[] result;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] > number){
            listIndex.add(i);
            }
        }
        if(listIndex.size() > 0){
            result = new int[listIndex.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = listIndex.get(i);
            }
        }else{
            result = new int[]{-1};
        }
        endTime = System.nanoTime();
        return result;
    }
    /**
     * Sử dụng thuật toán tìm kiếm nhị phân, tìm chỉ số phần tử đầu tiên có giá trị bằng phần tử trên mảng được sắp xếp,
     * hiển thị ra màn hình và lưu vào file OUTPUT5.TXT
     * @param arr mảng dùng để tìm kiếm tuyến tính
     * @param number biến dùng để nhập phần tử cần tìm
     * @return trả về vị trí phần tử có kết quả lớn hơn biến nhập vào, nếu không lớn hơn trả về -1
     */

    public int binarySearch(float arr[], float number){
        startTime = System.nanoTime();
            int left = 0;
            int right = arr.length;
        int mid = left + (right - left)/2;
        float[] sorted = this.bubbleSort(arr);
        while ((left < right) && (sorted[mid] != number)) {
            if (number < sorted[mid]) {
                right = mid - 1;
            } else if (number > sorted[mid]) {
                left = mid + 1;
            }
            mid = left + (right - left)/2;
        }
        endTime = System.nanoTime();
        return  (sorted[mid] == number)? mid:-1;
    }

}
