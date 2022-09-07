package com.mycompany.rental;

import java.math.BigDecimal;

public class Mileage {
    
    private BigDecimal maxMileage;
    private BigDecimal totalMileage;
    private BigDecimal chargeTotal;
    private BigDecimal price;
    private BigDecimal fees;
    private Mileage mileage;
    private BigDecimal gas;

    public Mileage(BigDecimal maxMileage, BigDecimal totalMileage, BigDecimal chargeTotal){
        this.maxMileage = maxMileage;
        this.totalMileage = totalMileage;
        this.chargeTotal = chargeTotal;
    }

    public BigDecimal getMaxMileage(){
        return maxMileage;
    }

    public BigDecimal getTotalMileage(){
        return totalMileage;
    }

    public BigDecimal getChargeTotal(){
        Rental rental = new Rental(price, fees, mileage, gas);
        int charged = totalMileage.compareTo(maxMileage);
        if (charged == 1){
            return rental.getPrice().add(chargeTotal.add(rental.getFees()));
        }
        return chargeTotal;
    }

}
