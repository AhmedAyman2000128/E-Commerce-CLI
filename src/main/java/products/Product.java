package products;

import Exceptions.InsufficientQuantityException;

public abstract class Product {
    private String name; // name of product ex: DinaFarmsCheese
    private double price; // Unit price of product
    private int quantity; // product quantity found in store
    public Product(String name,double price,int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void reduceQuantity(int quantityToReduce){
        if(quantityToReduce > this.quantity){
            throw new InsufficientQuantityException("Only " + this.getQuantity() + " available for " + this.getName());
        }
        this.quantity -=quantityToReduce;
    }
    public void increaseQuantity(int quantityToIncrease){
        this.quantity += quantityToIncrease;
    }
}
