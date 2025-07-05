package Main;

import Customer.Customer;
import products.Biscuits;
import products.Cheese;
import products.ScratchCard;
import products.TV;
import services.Cart;

public class Main {
    public static void main(String[] args) {
        // Products in the store
        //// Shippable products
        Cheese dinaFarmsCheese = new Cheese("dinaFarms",50,5,250,"1-7-2026");
        TV toshiba = new TV("toshiba",10000,10,10000);
        Biscuits ulker = new Biscuits("ulker",10,1000,50,"10-8-2025");

        //// Non-shippable products
        ScratchCard sc = new ScratchCard("Vodafone card",20,1000);

        // Customer
        Customer c1 = new Customer("Ahmed Ayman Abd El Fatah",20000);

        // Cart Addition
        c1.addToCart(dinaFarmsCheese,2);
        c1.addToCart(toshiba,1);
        c1.addToCart(ulker,10);
        c1.addToCart(sc,1);

        // Checkout
        c1.checkout();
    }
}