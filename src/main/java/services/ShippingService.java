package services;

import products.Product;
import products.Shippable;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ShippingService {
//    public static ArrayList<Shippable>[] getShippableItems(){
//        ArrayList<Shippable>shippables = new ArrayList<>();
//        //TODO: Pass cart as an argument
//        //TODO: Loop the cart and add to the shippables
//        //TODO: Return Shippables
//
//    }
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
        return Math.ceil(totalWeight) * 10;
    }
    public static void printReceipt(HashMap<Shippable,Integer>shippableItems){
        if(shippableItems.size() == 0){
            return;
        }
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for(Shippable p:shippableItems.keySet()){
            int quantity = shippableItems.get(p);
            double productWeight = p.getWeight()*quantity;
            totalWeight+=productWeight;
            System.out.println(quantity + "x " + p.getName() + "     " + parseWeight(productWeight));
        }
        System.out.println("Total package weight " + parseWeight(totalWeight));
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
