package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public abstract class Beverage extends MenuItem {

    // Enum for sizes
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    private Size size;

    public Beverage(String sku, String name, BigDecimal basePrice, Size size) {
        super(sku, name, basePrice);

        // validation (important for tests)
        if (size == null) {
            throw new IllegalArgumentException("size cannot be null");
        }

        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public BigDecimal sizeMultiplier() {
        if (size == Size.SMALL) {
            return new BigDecimal("1.00");
        } else if (size == Size.MEDIUM) {
            return new BigDecimal("1.20");
        } else {
            return new BigDecimal("1.40");
        }
    }
}
