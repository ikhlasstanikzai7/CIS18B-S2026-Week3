package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class MenuItem {
    private String sku;
    private String name;
    private BigDecimal price;

    public MenuItem(String sku, String name, BigDecimal price) {

        if(sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("sku cannot be null or blank");
        }
        
    }
}
