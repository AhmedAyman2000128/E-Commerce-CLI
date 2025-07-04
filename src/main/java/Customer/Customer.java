package Customer;

import Exceptions.InsufficientBalanceException;

public class Customer {
    private String name;
    private double balance;
    public Customer(String name,double balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
