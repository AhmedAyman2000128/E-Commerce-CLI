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
        Cheese dinaFarmsCheese = new Cheese("dinaFarms",40,10,100,"24-7-2025");
        TV toshiba = new TV("toshiba",10000,10,4000);
        Biscuits ulker = new Biscuits("ulker",10,1000,50,"6-7-2025");
        ScratchCard sc = new ScratchCard("Vodafone card",20,1000);
        Cart cart = new Cart();
        Customer customer = new Customer("Ahmed Ayman",9000);
        cart.add(dinaFarmsCheese,2);
        cart.add(toshiba,1);
        cart.add(ulker,10);
        cart.add(sc,1);
        Checkout.checkout(customer,cart);


        System.out.println("ulker remaining : " + ulker.getQuantity());
    }
}