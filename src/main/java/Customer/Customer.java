package Customer;

import Exceptions.EmptyCartException;
import Exceptions.ExpiredProductException;
import Exceptions.InsufficientBalanceException;
import products.ExpirableProduct;
import products.Product;
import products.Shippable;
import services.Cart;
import services.ShippingService;

import java.util.HashMap;

public class Customer {
    private String name;
    private double balance;
    private Cart cart;
    public Customer(String name,double balance){
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public String getName() {
        return name;
    }

    public void addToCart(Product p,int quantity){
        this.cart.add(p,quantity);
    }
    public void removeFromCart(Product p,int quantity){
        this.cart.remove(p,quantity);
    }
    public void setName(String name) {
        this.name = name;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void withdraw(double withdrawalAmount){
        if(withdrawalAmount > this.balance){
            throw new InsufficientBalanceException("Insufficient balance !");
        }
        else{
            this.balance -= withdrawalAmount;
        }
    }

    public void checkout(){
        // If cart is empty throw error
        if(this.cart.isEmpty()){
            throw new EmptyCartException("Cart is empty !");
        }
        // If the cart contains expired products
        if(this.cart.getExpiredProducts().length() != 0){
            throw new ExpiredProductException(this.cart.getExpiredProducts() + " Expired!");
        }

        // Checkout
        double totalCost = this.cart.getTotalCost();
        this.withdraw(totalCost);
        this.cart.printReceiptAndClear();

        System.out.printf("%-25s %10.2f EGP%n", "Customer balance after payment:", this.getBalance());
    }
}
