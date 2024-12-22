package org.example.twentyfour.three;


public record MultiplierPair(Integer multiplicand, Integer multiplier) {
    public int getProduct() {
        return multiplicand * multiplier;
    }
}
