package products;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class ExpirableProduct extends Product{
    private LocalDate expirationDate;
    public ExpirableProduct(String name,double price,int quantity,String expirationDate){
        super(name,price,quantity);
        this.expirationDate = LocalDate.parse(expirationDate,DateTimeFormatter.ofPattern("d-M-yyyy"));
    }

    public String getExpirationDate() {
        return expirationDate.format(DateTimeFormatter.ofPattern("d-M-yyyy"));
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public boolean isExpired(){
        return LocalDate.now().isAfter(this.expirationDate) || LocalDate.now().isEqual(this.expirationDate);
    }
}
