package sample;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(){
        this.name = "";
        this.price = 0;
        this.quantity = 0;
    }
    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Double setPrice(double price) {
        this.price = price;
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Integer setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }
}
