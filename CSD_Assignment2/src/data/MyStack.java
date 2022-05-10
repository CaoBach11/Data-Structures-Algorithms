package data;

public class MyStack<Product> {
    Node<Product> nodeHead;

    public MyStack() {
    }

    public MyStack(Node<Product> nodeHead) {
        this.nodeHead = nodeHead;
    }
    /**
     * Kiểm tra nếu Stack trống.
     * @return true nếu stack trống.
     */
    public boolean isEmpty(){
        return (this.nodeHead == null);
    }

    /**
     * Add phần tử mới vào Stack.
     * @param info tham số của phần tử mới.
     */
    public void push(Product info){
        Node<Product> newNode = new Node<>(info);
        newNode.setNodeNext(this.nodeHead);
        this.nodeHead = newNode;
    }

    /**
     * Lấy phần tử và xóa phần tử khỏi Stack
     * @return Stack sau khi xóa phần tử.
     */
    public Product pop() {
        Product result = null;
        if (!isEmpty()) {
            result = this.nodeHead.getInfo();
            this.nodeHead = this.nodeHead.getNodeNext();
        }
        return result;
    }

    /**
     * Lấy độ dài của Stack.
     * @return length of Stack.
     */
    public int length(){
        int result = 0;
        Node<Product> current = this.nodeHead;
        while (current != null){
            result++;
            current = current.getNodeNext();
        }
        return result;
    }

    /**
     * Format in ra console.
     */
    public void displayProductInfo() {
        Node productInfo = this.nodeHead;
        System.out.printf("%-5s%-5s%-15s%-5s%-7s%-5s%s", "ID", "|", "Product Name", "|", "Price", "|", "Quantity\n");
        System.out.println("--------------------------------------------------");
        while (productInfo != null) {
            System.out.println(productInfo.getInfo());
            productInfo = productInfo.getNodeNext();
        }
        System.out.println("--------------------------------------------------");
    }
}