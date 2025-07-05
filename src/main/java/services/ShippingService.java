package services;

import products.Shippable;
import java.util.HashMap;

public abstract class ShippingService {
    public static double computeShippingCost(HashMap<Shippable,Integer>shippableItems){
        if(shippableItems.size() == 0){
            return 0;
        }
        double totalWeight = 0;
        for(Shippable product:shippableItems.keySet()){
            int noOfProducts = shippableItems.get(product);
            totalWeight += product.getWeight() * noOfProducts;
        }
        totalWeight = totalWeight / 1000;
        //shipping is 10 EGP for each 10kg and minimum is 10
        if(totalWeight<10){
            return 10;
        }
        return Math.ceil(totalWeight/10) * 10;
    }
    public static void printReceipt(HashMap<Shippable,Integer>shippableItems){
        if(shippableItems.size() == 0){
            return;
        }
        double totalWeight = 0;
        System.out.println("************ Shipment notice *************");
        System.out.printf("%-5s %-20s %10s%n", "Qty", "Item", "Weight");
        for(Shippable p:shippableItems.keySet()){
            int quantity = shippableItems.get(p);
            double productWeight = p.getWeight()*quantity;
            totalWeight+=productWeight;
            System.out.printf("%-5s %-20s %10s%n", quantity + "x", p.getName(), parseWeight(productWeight));
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-26s %10s%n", "Total package weight", parseWeight(totalWeight));
        System.out.println();
    }
    private static String parseWeight(double weight) {
        if (weight > 1000000) {
            return (weight / 1000000 + "T");
        } else if (weight > 1000) {
            return (weight / 1000) + "Kg";
        } else if (weight < 1000) {
            return (weight) + "g";
        } else {
            return "X";
        }
    }
}
