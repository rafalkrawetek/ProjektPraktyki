abstract class Product {
    private String name;
    private double price;
    private int quantity;

    Product(String name, double price, int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    void changePrice(double price) {
        this.price += price;
    }

    int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    void changeQuantity(int quantity) {
        this.quantity += quantity;
    }
    abstract int getSize();
}
