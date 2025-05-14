package com.affordmed.stockservice.controller;

import com.affordmed.stockservice.model.AverageResponse;
import com.affordmed.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/{ticker}")
    public AverageResponse getAverage(
            @PathVariable String ticker,
            @RequestParam int minutes,
            @RequestParam String aggregation
    ) {
        if (!"average".equalsIgnoreCase(aggregation)) {
            throw new IllegalArgumentException("Only 'average' aggregation is supported.");
        }
        return stockService.getAverage(ticker, minutes);
    }
}
