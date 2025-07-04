package org.p1;


import java.time.LocalDate;

public abstract class ExpirableProduct {
    private LocalDate expirationDate;
    public ExpirableProduct(LocalDate expirationDate){
        this.expirationDate = expirationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public boolean isExpired(){
        return LocalDate.now().isAfter(this.expirationDate);
    }
}
