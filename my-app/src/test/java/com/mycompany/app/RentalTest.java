package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.rental.Mileage;
import com.mycompany.rental.Rental;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RentalTest {

    private BigDecimal price;
    private BigDecimal fees;
    private Mileage mileage;
    private BigDecimal gas;
    private BigDecimal maxMileage;
    private BigDecimal totalMileage;
    private BigDecimal totalCost;
    private BigDecimal chargeTotal;

    @Before
    public void setup(){
        price = new BigDecimal(1000);
        fees = new BigDecimal(100);
        mileage = new Mileage(maxMileage = new BigDecimal(5000), totalMileage = new BigDecimal(2500), chargeTotal = new BigDecimal(0));
        gas = new BigDecimal(50);

    }
    @Test
    public void testMileageConstruction(){
        Mileage mileage = new Mileage(maxMileage, totalMileage, chargeTotal);
        assertEquals("The max mileage is correct", mileage.getMaxMileage(), maxMileage);
        assertEquals("The total mileage is correct", mileage.getTotalMileage(), totalMileage);
        assertEquals("The charge total is correct", mileage.getChargeTotal(), chargeTotal);
    }

    @Test
    public void testTotalCost(){
        totalCost = price.add(fees).add(gas);
        assertEquals(totalCost, totalCost);
    }

    @Test 
    public void testOverMileage(){
        Rental rental = new Rental(price, fees, mileage, gas);
        boolean overMileage = true;
        assertTrue("rental is over mileage", rental.exceededMileage(overMileage));
    }
}
