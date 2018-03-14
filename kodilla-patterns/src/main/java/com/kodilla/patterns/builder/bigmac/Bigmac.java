package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.definitions.INGREDIENTS;
import com.kodilla.patterns.builder.bigmac.definitions.SAUCE;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {
    private final boolean roll;
    private final int burgers;
    private final SAUCE sauce;
    private final List<INGREDIENTS> ingredients;

    public static class BigmacBuilder {
        private boolean roll;
        private int burgers;
        private SAUCE sauce;
        private List<INGREDIENTS> ingredients = new ArrayList<>();

        public BigmacBuilder roll(boolean roll) {
            this.roll = roll;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(SAUCE sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(INGREDIENTS ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (burgers < 1 || burgers > 3) {
                throw new IllegalStateException("Wrong number of burgers!");
            }
            return new Bigmac(roll, burgers, sauce, ingredients);
        }
    }

    private Bigmac(final boolean roll, final int burgers, final SAUCE sauce, List<INGREDIENTS> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public boolean isRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public SAUCE getSauce() {
        return sauce;
    }

    public List<INGREDIENTS> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        String rollString = (roll) ? "Sesame Seed Bun" : "BunWithoutSesameSeed";
        return "Bigmac{" +
                "roll='" + rollString + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}