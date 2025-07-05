package services;

import Exceptions.ExpiredProductException;
import Exceptions.InsufficientQuantityException;
import products.ExpirableProduct;
import products.Product;
import products.Shippable;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products;
    private double subTotal;
    public Cart(){
        products = new HashMap();
        subTotal = 0;
    }
    public Cart(HashMap<Product,Integer>products){
        this.products = products;
        this.subTotal = 0;
        for(Product p: products.keySet()){
            int productQuantity = products.get(p);
            this.subTotal += p.getPrice() * productQuantity;
        }
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void add(Product product, int quantity){
        product.reduceQuantity(quantity);
        //Adding the same product to the cart
        if(this.products.containsKey(product)){
            this.products.put(product,this.products.get(product)+quantity);
        }
        //Adding product for the first time in the cart
        else{
            this.products.put(product,quantity);
        }
        this.subTotal += product.getPrice() * quantity;
    }
    public void remove(Product product,int quantity){
        Integer currentQuantity = this.products.get(product);
        if(currentQuantity == null){
            throw new InsufficientQuantityException(product.getName() + " not in the cart!");
        }
        else{
            if(currentQuantity<quantity){
                throw new InsufficientQuantityException(currentQuantity + " of " + product.getName() + " only exist in cart not " + quantity);
            }
            else if(currentQuantity.equals(quantity)){
                this.products.remove(product);
                this.subTotal -= product.getPrice() * quantity;
            }
            else{
                this.products.put(product,currentQuantity - quantity);
                product.increaseQuantity(quantity);
                this.subTotal -= product.getPrice() * quantity;
            }
        }
    }
    private void clearCart(){
        this.products.clear();
        this.subTotal = 0;
    }
    public boolean isEmpty(){
        return this.products.size() == 0;
    }
    public HashMap<Shippable,Integer> getShippableItems(){
        HashMap<Shippable,Integer> shippableItems = new HashMap<>();
        for(Product p: this.products.keySet()){
            int productQuantity = this.products.get(p);
            if(p instanceof Shippable){
                shippableItems.put((Shippable) p,productQuantity);
            }
        }
        return shippableItems;
    }
    public void printReceiptAndClear(){
        HashMap<Shippable,Integer> shippableItems = this.getShippableItems();
        double shippingCost = ShippingService.computeShippingCost(shippableItems);
        double totalCost = this.subTotal + shippingCost;
        //print shipment notice if shipping exists
        ShippingService.printReceipt(shippableItems);

        //print checkout receipt
        System.out.println("************ Checkout Receipt ************");
        System.out.printf("%-5s %-20s %10s%n", "Qty", "Item", "Price");
        for(Product p: this.products.keySet()){
            int quantity = this.products.get(p);
            double price = p.getPrice() * quantity;
            System.out.printf("%-5s %-20s %10.2f EGP%n", quantity + "x", p.getName(), price);
        }

        System.out.println("-----------------------------------------");
        System.out.printf("%-25s %10.2f EGP%n", "SubTotal", subTotal);
        System.out.printf("%-25s %10.2f EGP%n", "Shipping", shippingCost);
        System.out.printf("%-25s %10.2f EGP%n", "Amount", totalCost);
        System.out.println();
        this.clearCart();
    }
    public double getTotalCost(){
        return (this.subTotal + ShippingService.computeShippingCost(this.getShippableItems()));
    }
    public String getExpiredProducts(){
        StringBuilder expiredProducts = new StringBuilder();
        for(Product p :this.products.keySet()){
            if(p instanceof ExpirableProduct){
                if(((ExpirableProduct) p).isExpired()){
                    expiredProducts.append(p.getName()).append(", ");
                }
            }
        }
        if(expiredProducts.length()!=0){
            return expiredProducts.substring(0,expiredProducts.length()-2);
        }
        return "";
    }
}
