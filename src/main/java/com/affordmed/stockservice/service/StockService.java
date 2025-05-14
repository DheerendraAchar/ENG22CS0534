package com.affordmed.stockservice.service;

import com.affordmed.stockservice.model.AverageResponse;
import com.affordmed.stockservice.model.PriceData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class StockService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://20.244.56.144/evaluation-service/stocks/";

    public AverageResponse getAverage(String ticker, int minutes) {
        String url = BASE_URL + ticker + "?minutes=" + minutes;
        PriceData[] data = restTemplate.getForObject(url, PriceData[].class);

        if (data == null || data.length == 0) return new AverageResponse(0, new ArrayList<>());

        double sum = 0;
        for (PriceData price : data) sum += price.getPrice();

        return new AverageResponse(sum / data.length, Arrays.asList(data));
    }

    public List<PriceData> getPriceData(String ticker, int minutes) {
        String url = BASE_URL + ticker + "?minutes=" + minutes;
        PriceData[] data = restTemplate.getForObject(url, PriceData[].class);
        return data != null ? Arrays.asList(data) : new ArrayList<>();
    }
}
