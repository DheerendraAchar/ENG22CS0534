package com.affordmed.stockservice.model;

public class PriceData {
    private double price;
    private String lastUpdatedAt;

    public PriceData() {}

    public PriceData(double price, String lastUpdatedAt) {
        this.price = price;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
