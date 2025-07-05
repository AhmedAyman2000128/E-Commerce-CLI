package services;

import Customer.Customer;
import Exceptions.EmptyCartException;
import Exceptions.ExpiredProductException;
import products.ExpirableProduct;
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

        // Extracting shippable products and check if there is any expired product
        for(Product p: cartProducts.keySet()){
            if(p instanceof ExpirableProduct){
                if(((ExpirableProduct) p).isExpired()){
                    throw new ExpiredProductException(p.getName() + " is Expired!");
                }
            }
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
        System.out.println("************ Checkout Receipt ************");
        System.out.printf("%-5s %-20s %10s%n", "Qty", "Item", "Price");
        for(Product p: cartProducts.keySet()){
            int quantity = cartProducts.get(p);
            double price = p.getPrice() * quantity;
            System.out.printf("%-5s %-20s %10.2f EGP%n", quantity + "x", p.getName(), price);
        }

        System.out.println("-----------------------------------------");

        System.out.printf("%-25s %10.2f EGP%n", "SubTotal", subTotal);
        System.out.printf("%-25s %10.2f EGP%n", "Shipping", shippingCost);
        System.out.printf("%-25s %10.2f EGP%n", "Amount", totalCost);
        System.out.println();
        System.out.printf("%-25s %10.2f EGP%n", "Customer balance after payment:", customer.getBalance());
    }
}
