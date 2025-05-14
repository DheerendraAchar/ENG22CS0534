package com.affordmed.stockservice.model;

import java.util.List;
import java.util.Map;

public class CorrelationResponse {
    private double correlation;
    private Map<String, AverageResponse> stocks;

    public CorrelationResponse() {}

    public CorrelationResponse(double correlation, Map<String, AverageResponse> stocks) {
        this.correlation = correlation;
        this.stocks = stocks;
    }

    public double getCorrelation() {
        return correlation;
    }

    public void setCorrelation(double correlation) {
        this.correlation = correlation;
    }

    public Map<String, AverageResponse> getStocks() {
        return stocks;
    }

    public void setStocks(Map<String, AverageResponse> stocks) {
        this.stocks = stocks;
    }
}
