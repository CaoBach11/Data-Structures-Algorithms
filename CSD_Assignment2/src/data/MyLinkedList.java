package data;

public class MyLinkedList<Product> {
    public Product info;
    Node<Product> nodeHead;
    Node<Product> nodeTail;

    /**
     * Default constructor.
     */
    public MyLinkedList() {
    }

    public MyLinkedList(Node<Product> nodeHead, Node<Product> nodeTail) {
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
     * Thêm node vào đầu MyLinkedList.
     *
     * @param product là tham số của phần tử thêm ở đầu MyLinkedList.
     */
    public void addToFront(Product product){
        Node<Product> newNode = new Node<>(product);
        if(isEmpty()){
            this.nodeHead = newNode;
            this.nodeTail = newNode;
        }
        newNode.setNodeNext(nodeHead);
        nodeHead = newNode;
    }
    /**
     * Thêm node vào đuôi MyLinkedList.
     *
     * @param product là tham số của phần tử thêm ở đuôi MyLinkedList.
     */
    public void addToTail(Product product){
        Node<Product> newNode = new Node<>(product);
        if(isEmpty()){
            this.nodeHead = newNode;
        }else {
            this.nodeTail.setNodeNext(newNode);
        }
        this.nodeTail = newNode;
    }
    /**
     * Thêm phần tử vào vị trí cần trong LinkedList
     * @param position The position of new item
     * @param item     The item to be inserted
     */
    public void insertAfterPosition(int position, Product item) {
        Node<Product> newNode = new Node<>(item);
        Node<Product> current = this.nodeHead;
        if (position == 0) {
            this.addToFront(item);
        }
        position--;
        while ((current != null) && (position > 0)) {
            position--;
            current = current.getNodeNext();
        }
        if ((position == 0) && (current != null)) {
            newNode.setNodeNext(current.getNodeNext());
            current.setNodeNext(newNode);
        }
    }
    /**
     * Lấy phần tử và xóa phần tử khỏi LinkedList
     */
    public void deleteElement(Product product) {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty!!!");
        }
        Node<Product> currentNode = this.nodeHead;
        if (this.nodeHead.info.equals(product)) {
            this.nodeHead = nodeHead.nodeNext;
        } else {
            while (currentNode.nodeNext != null) {
                if (currentNode.nodeNext.info.equals(product)) {
                    Node<Product> temptNode = currentNode.nodeNext;
                    currentNode.nodeNext = temptNode.nodeNext;
                } else {
                    currentNode = currentNode.nodeNext;
                }
            }
        }
    }
    /**
     * Lấy phần tử và xóa phần tử khỏi đuôi LinkedList
     */
    public void deleteAtTail(Product product) {
        if (nodeHead == null) return;
        Node<Product> lastNode = nodeHead;
        Node<Product> previousNode = null;
        while (lastNode.nodeNext != null) {
            previousNode = lastNode;
            lastNode = lastNode.nodeNext;
        }
        if (previousNode == null) {
            return;
        } else {
            previousNode.nodeNext = lastNode.nodeNext;
        }
    }
    /**
     * Swap vị trí của firstNode và secondNode
     * @param firstNode Node đầu của LinkedList
     * @param secondNode Node sau của LinkedList
     */
    public void swap(Node<Product> firstNode, Node<Product> secondNode){
        Product temp;
        temp = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = temp;
    }
    /**
     * Lấy độ dài của LinkedList.
     * @return length of LinkedList.
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
     * Xóa Node
     */
    public void clear(){
        this.nodeHead = null;
        this.nodeTail = null;
    }
    /**
     * Get data of node with index of node
     * @param index Index of node
     * @return data of node
     */
    public Product getElementByIndex(int index) {
        Product result = null;
        Node<Product> current = this.nodeHead;
        if (!isEmpty()) {
            while ((current != null) && (index > 0)) {
                index--;
                current = current.getNodeNext();
            }
            if ((index == 0) && (current != null)) {
                result = current.getInfo();
            }
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
