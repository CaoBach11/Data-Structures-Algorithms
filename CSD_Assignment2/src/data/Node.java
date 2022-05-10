package data;

public class Node<Product>{
     Product info;
     Node<Product> nodeNext;

    public Node() {
    }

    public Node(Product info) {
        this(info,null);
    }

    public Node(Product info, Node<Product> nodeNext) {
        this.info = info;
        this.nodeNext = nodeNext;
    }



    public Product getInfo() {
        return info;
    }

    public void setInfo(Product info) {
        this.info = info;
    }

    public Node<Product> getNodeNext() {
        return nodeNext;
    }

    public void setNodeNext(Node<Product> nodeNext) {
        this.nodeNext = nodeNext;
    }

    @Override
    public String toString() {
        return this.info.toString();
    }
}
