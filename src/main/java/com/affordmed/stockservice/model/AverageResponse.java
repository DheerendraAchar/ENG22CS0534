package com.affordmed.stockservice.model;

import java.util.List;

public class AverageResponse {
    private double averageStockPrice;
    private List<PriceData> priceHistory;

    public AverageResponse() {}

    public AverageResponse(double averageStockPrice, List<PriceData> priceHistory) {
        this.averageStockPrice = averageStockPrice;
        this.priceHistory = priceHistory;
    }

    public double getAverageStockPrice() {
        return averageStockPrice;
    }

    public void setAverageStockPrice(double averageStockPrice) {
        this.averageStockPrice = averageStockPrice;
    }

    public List<PriceData> getPriceHistory() {
        return priceHistory;
    }

    public void setPriceHistory(List<PriceData> priceHistory) {
        this.priceHistory = priceHistory;
    }
}
