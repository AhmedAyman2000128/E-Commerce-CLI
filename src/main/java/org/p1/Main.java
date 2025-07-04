package org.p1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void print(Object b){
        System.out.println(b.hashCode());
    }
    public static void main(String[] args) {
        HashMap<Integer,Integer>x = new HashMap<>();
        x.put(1,2);
        if(x.containsKey(1)){
            x.put(1,x.get(1)+3);
        }
//        x.put(1,3);
        for (Map.Entry<Integer, Integer> entry : x.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " => " + value);
        }
    }
}