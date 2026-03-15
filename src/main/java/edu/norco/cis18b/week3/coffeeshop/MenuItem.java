package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class MenuItem {
    private String sku;
    private String name;
    private BigDecimal price;

    public MenuItem(String sku, String name, BigDecimal price) {

        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("sku cannot be null or blank");
        }
        
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("sku cannot be null or blank");
        }
        
        if (price == null) {
            throw new IllegalArgumentException("price cannot be null");
        }
        
        if (price.compareTo(BigDecimal.Zero) < 0) {
            throw new IllegalArgumentException("price must be >= 0");

            this.sku = sku;
            this.name = name;
            this.price = price;
        }
    }
}
