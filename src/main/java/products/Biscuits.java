package products;
public class Biscuits extends ExpirableProduct implements Shippable{
    private double weight;
    public Biscuits(String name, double price, int quantity, double weight, String expirationDate){
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}
