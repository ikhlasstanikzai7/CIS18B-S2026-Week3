package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class PricingCatalog {

    private static PricingCatalog instance;

    private PricingCatalog() {
    }

    public static PricingCatalog getInstance() {
        if (instance == null) {
            instance = new PricingCatalog();
        }
        return instance;
    }

    public BigDecimal getBasePrice(String productKey) {
        if (productKey.equals("LATTE")) {
            return new BigDecimal("4.50");
        } else if (productKey.equals("COLD_BREW")) {
            return new BigDecimal("4.00");
        } else if (productKey.equals("CUSTOM")) {
            return new BigDecimal("4.25");
        } else {
            throw new IllegalArgumentException("Unknown product key");
        }
    }
}
