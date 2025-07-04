package products;

import java.time.LocalDate;

public class Cheese extends ExpirableProduct implements Shippable{
    private double weight;
    public Cheese(String name,double price,int quantity,double weight,String expirationDate){
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
