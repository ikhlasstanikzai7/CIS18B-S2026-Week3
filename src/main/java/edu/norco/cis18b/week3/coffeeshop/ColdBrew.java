package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class ColdBrew extends Beverage {

    public ColdBrew(Size size) {
        super("COLD_BREW", "Cold Brew", new BigDecimal("4.00"), size);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("4.00").multiply(sizeMultiplier());
    }
}
