package services;

import Customer.Customer;
import Exceptions.EmptyCartException;
import products.Product;
import products.Shippable;

import java.util.HashMap;

public class Checkout {
    public static void checkout(Customer customer,Cart cart){
        // If cart is empty throw error
        if(cart.isEmpty()){
            throw new EmptyCartException("Cart is empty !");
        }

        double subTotal = 0;
        HashMap<Shippable,Integer>shippableItems = new HashMap<>();
        HashMap<Product,Integer>cartProducts = (HashMap<Product, Integer>) cart.getProducts();

        // Extracting shippable products only
        for(Product p: cartProducts.keySet()){
            int productQuantity = cartProducts.get(p);
            if(p instanceof Shippable){
                shippableItems.put((Shippable) p,productQuantity);
            }
            subTotal += p.getPrice() * productQuantity;
        }

        double shippingCost = ShippingService.computeShippingCost(shippableItems);
        double totalCost = shippingCost + subTotal;

        // Withdrawing money before getting receipt
        customer.withdraw(totalCost);

        //print shipment notice if shipping exists
        ShippingService.printReceipt(shippableItems);

        //print checkout receipt
        for(Product p: cartProducts.keySet()){
            int quantity = cartProducts.get(p);
            System.out.println(quantity + "x" + " " + p.getName() + "     " + (p.getPrice()*quantity) + "EGP");
        }

        System.out.println("--------------------");

        System.out.println("SubTotal" + "     " + subTotal);
        System.out.println("Shipping" + "     " + shippingCost);
        System.out.println("Amount" + "     " + totalCost);
    }
}
