package edu.norco.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomDrink extends Beverage {

    public enum Milk {
        WHOLE, OAT, ALMOND, SKIM
    }

    public enum Syrup {
        VANILLA, CARAMEL, HAZELNUT, NONE
    }

    public enum Temperature {
        HOT, ICED
    }

    private Milk milk;
    private Syrup syrup;
    private Temperature temperature;
    private int espressoShots;
    private List<String> extras;

    private CustomDrink(Builder builder) {
        super("CUSTOM", "Custom Drink", new BigDecimal("4.25"), builder.size);

        this.milk = builder.milk;
        this.syrup = builder.syrup;
        this.temperature = builder.temperature;
        this.espressoShots = builder.espressoShots;
        this.extras = builder.extras;
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal price = new BigDecimal("4.25");

        // extra espresso shots
        if (espressoShots > 1) {
            int extraShots = espressoShots - 1;
            price = price.add(new BigDecimal("0.75").multiply(new BigDecimal(extraShots)));
        }

        // syrup
        if (syrup != Syrup.NONE) {
            price = price.add(new BigDecimal("0.50"));
        }

        // extras
        price = price.add(new BigDecimal("0.25").multiply(new BigDecimal(extras.size())));

        // size multiplier
        price = price.multiply(sizeMultiplier());

        return price;
    }

    // ===== BUILDER CLASS =====
    public static class Builder {

        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE;
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;
        private List<String> extras = new ArrayList<>();

        public Builder size(Size size) {
            this.size = size;
            return this;
        }

        public Builder milk(Milk milk) {
            this.milk = milk;
            return this;
        }

        public Builder syrup(Syrup syrup) {
            this.syrup = syrup;
            return this;
        }

        public Builder temperature(Temperature temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder espressoShots(int shots) {
            this.espressoShots = shots;
            return this;
        }

        public Builder addExtra(String extra) {
            if (extra == null || extra.isBlank()) {
                throw new IllegalArgumentException("extra cannot be null or blank");
            }
            extras.add(extra);
            return this;
        }

        public CustomDrink build() {
            if (espressoShots < 1) {
                throw new IllegalArgumentException("espresso shots must be >= 1");
            }

            return new CustomDrink(this);
        }
    }
}
