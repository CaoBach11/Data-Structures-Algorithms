package data;

public class Product {
    private String idProduct;
    private String nameProduct;
    private int quantity;
    private double price;

    public Product() {

    }

    public Product(String idProduct, String nameProduct, int quantity, double price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-5s%-15s%-5s%-7.1f%-5s%s", idProduct, "|", nameProduct, "|", price, "|", quantity);    }
}
