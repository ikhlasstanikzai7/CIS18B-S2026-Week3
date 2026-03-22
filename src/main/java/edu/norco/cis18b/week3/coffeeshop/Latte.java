package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class Latte extends Beverage {

    public Latte(Size size) {
        super("LATTE", "Latte", new BigDecimal("4.50"), size);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("4.50").multiply(sizeMultiplier());
    }
}
