package org.p1;

import Exceptions.InsufficientQuantityException;

import java.util.HashMap;
import java.util.Map;


public class Cart {
    Map<Product,Integer> products;
    public Cart(){
        products = new HashMap();
    }
    public Cart(HashMap<Product,Integer>products){
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public void add(Product product,int quantity){
        try{
            product.reduceQuantity(quantity);
            //Adding the same product to the cart
            if(this.products.containsKey(product)){
                this.products.put(product,this.products.get(product)+quantity);
            }
            //Adding product for the first time in the cart
            else{
                this.products.put(product,quantity);
            }
        }
        catch (InsufficientQuantityException e){
            System.out.println(e.getMessage());
        }
    }
    public void remove(Product product,int quantity){
        Integer currentQuantity = this.products.get(product);
        if(currentQuantity == null){
            throw new InsufficientQuantityException(product.getName() + " not in the cart!");
        }
        else{
            if(currentQuantity<quantity){
                throw new InsufficientQuantityException(currentQuantity + " of " + product.getName() + " only exist not " + quantity);
            }
            else if(currentQuantity.equals(quantity)){
                this.products.remove(product);
            }
            else{
                this.products.put(product,currentQuantity - quantity);
                product.increaseQuantity(quantity);
            }
        }
    }
}
