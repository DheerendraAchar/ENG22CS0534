package com.affordmed.stockservice.controller;

import com.affordmed.stockservice.model.AverageResponse;
import com.affordmed.stockservice.model.CorrelationResponse;
import com.affordmed.stockservice.model.PriceData;
import com.affordmed.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CorrelationController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stockcorrelation")
    public CorrelationResponse getCorrelation(
            @RequestParam int minutes,
            @RequestParam List<String> ticker
    ) {
        if (ticker.size() != 2) {
            throw new IllegalArgumentException("Exactly two tickers required.");
        }

        List<PriceData> x = stockService.getPriceData(ticker.get(0), minutes);
        List<PriceData> y = stockService.getPriceData(ticker.get(1), minutes);

        List<Double> xPrices = new ArrayList<>();
        List<Double> yPrices = new ArrayList<>();

        int n = Math.min(x.size(), y.size());
        for (int i = 0; i < n; i++) {
            xPrices.add(x.get(i).getPrice());
            yPrices.add(y.get(i).getPrice());
        }

        double correlation = calculatePearsonCorrelation(xPrices, yPrices);

        Map<String, AverageResponse> stockMap = new HashMap<>();
        stockMap.put(ticker.get(0), stockService.getAverage(ticker.get(0), minutes));
        stockMap.put(ticker.get(1), stockService.getAverage(ticker.get(1), minutes));

        return new CorrelationResponse(correlation, stockMap);
    }

    private double calculatePearsonCorrelation(List<Double> x, List<Double> y) {
        int n = x.size();
        if (n == 0) return 0;

        double meanX = x.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double meanY = y.stream().mapToDouble(Double::doubleValue).average().orElse(0);

        double num = 0, denX = 0, denY = 0;
        for (int i = 0; i < n; i++) {
            double dx = x.get(i) - meanX;
            double dy = y.get(i) - meanY;
            num += dx * dy;
            denX += dx * dx;
            denY += dy * dy;
        }

        return denX == 0 || denY == 0 ? 0 : num / Math.sqrt(denX * denY);
    }
}
