package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.rental.Mileage;
import com.mycompany.rental.Rental;

public class MileageTest {
    
    private BigDecimal maxMileage;
    private BigDecimal totalMileage;
    private BigDecimal price;
    private BigDecimal fees;
    private Mileage mileage;
    private BigDecimal gas;
    private BigDecimal chargeTotal;
    
    @Before
    public void setup(){
        Rental rental = new Rental(price, fees, mileage, gas);
        Mileage currentMileage = rental.getMileage();
        price = new BigDecimal(1000);
        fees = new BigDecimal(100);
        gas = new BigDecimal(50);
        maxMileage = new BigDecimal(5000);
        totalMileage = new BigDecimal(2500);
        chargeTotal = price.add(fees.add(gas));
    }

    @Test
    public void testConstruction() {
        Mileage mileage = new Mileage(maxMileage, totalMileage, chargeTotal);
        assertEquals("Max mileage", maxMileage, mileage.getMaxMileage());
        assertEquals("Total mileage", totalMileage, mileage.getTotalMileage());
    }

    @Test
    public void testMileageLeft(){
        Mileage mileage = new Mileage(maxMileage, totalMileage, chargeTotal);
        BigDecimal maxMileage = mileage.getMaxMileage();
        BigDecimal mileageLeft = maxMileage.subtract(totalMileage);
        assertEquals(maxMileage.subtract(totalMileage), mileageLeft);
    }

    @Test
    public void testChargeTotal(){
        Mileage mileage = new Mileage(maxMileage, totalMileage, chargeTotal);
        BigDecimal endCost = mileage.getChargeTotal();
        assertEquals(price.add(fees.add(gas)), endCost);
        
    }
}
