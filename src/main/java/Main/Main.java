package Main;

import Customer.Customer;
import products.Biscuits;
import products.Cheese;
import products.ScratchCard;
import products.TV;
import services.Cart;
import services.Checkout;

public class Main {
    public static void main(String[] args) {
        // Products in the store

        //// Shippable products
        Cheese dinaFarmsCheese = new Cheese("dinaFarms",50,5,250,"1-7-2026");
        TV toshiba = new TV("toshiba",10000,10,10000);
        Biscuits ulker = new Biscuits("ulker",10,1000,50,"10-8-2025");

        //// Non-shippable products
        ScratchCard sc = new ScratchCard("Vodafone card",20,1000);

        // Cart and Customer
        Customer customer = new Customer("Ahmed Ayman Abd El Fatah",20000);
        Cart cart = new Cart();

        // Cart Addition
        cart.add(dinaFarmsCheese,2);
        cart.add(toshiba,1);
        cart.add(ulker,10);
        cart.add(sc,1);

        // Checkout
        Checkout.checkout(customer,cart);
    }
}