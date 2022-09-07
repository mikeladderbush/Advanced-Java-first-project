package com.mycompany.rental;

import java.math.BigDecimal;

public class Rental 
{
    private BigDecimal price;
    private BigDecimal fees;
    private Mileage mileage;
    private BigDecimal gas;

    public Rental(BigDecimal price,BigDecimal fees, Mileage mileage, BigDecimal gas){
        this.price = price;
        this.fees = fees;
        this.mileage = mileage;
        this.gas = gas;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getFees() {
        return fees;
    }

    public Mileage getMileage() {
        return mileage;
    }

    public BigDecimal getGas() {
        return gas;
    }

    public boolean exceededMileage(Boolean boolean1){
        BigDecimal maxMileage = mileage.getMaxMileage();
        BigDecimal totalMileage = mileage.getTotalMileage();
        totalMileage.compareTo(maxMileage);
        boolean tooFar = (totalMileage.compareTo(maxMileage)) < 1;
        return tooFar;
    }
}
