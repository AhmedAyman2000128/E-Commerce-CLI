package Exceptions;

public class ExpiredProductException extends ECommerceException{
    public ExpiredProductException(String msg){
        super(msg);
    }
}
