package data;

public class MyQueue<Product> {
     Node<Product> nodeHead;
     Node<Product> nodeTail;

    /**
     * Default constructor.
     */
    public MyQueue() {

    }

    /**
     * Constructor.
     * @param nodeHead
     * @param nodeTail
     */
    public MyQueue(Node<Product> nodeHead, Node<Product> nodeTail) {
        this.nodeHead = nodeHead;
        this.nodeTail = nodeTail;
    }

    /**
     * Kiểm tra nếu Queue trống.
     * @return true nếu Queue trống.
     */
    public boolean isEmpty(){
         return (this.nodeHead == null);
    }

    /**
     * Add phần tử mới vào Queue.
     * @param info tham số của phần tử mới.
     */
    public void enQueue(Product info) {
        Node<Product> newNode = new Node<>(info);
        if (isEmpty()) {
            this.nodeHead = newNode;
            this.nodeTail = newNode;
        } else {
            this.nodeTail.setNodeNext(newNode);
            this.nodeTail = newNode;
        }
    }

    /**
     * Lấy phần tử và xóa phần tử khỏi Queue.
     * @return Queue sau khi xóa phần tử.
     */
    public Product deQueue() {
        Product result = null;
        if (!isEmpty()) {
            result = this.nodeHead.getInfo();
            this.nodeHead = this.nodeHead.getNodeNext();
            if (this.nodeHead == null) {
                this.nodeTail = null;
            }
        }
        return result;
    }

    /**
     * Lấy độ dài của Queue.
     * @return length of Queue.
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
