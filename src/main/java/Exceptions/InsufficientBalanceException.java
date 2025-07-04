package Exceptions;

public class InsufficientBalanceException extends ECommerceException{
    public InsufficientBalanceException(String msg){
        super(msg);
    }
}
