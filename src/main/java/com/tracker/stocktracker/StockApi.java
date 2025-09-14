package com.tracker.stocktracker;

import com.fasterxml.jackson.databind.*;
import org.springframework.web.client.RestTemplate;


public class StockApi {

    private static API api = new API();
    private static final String key = api.getKey();


    public Stock fetch(String symbol, int quantity, boolean isETF) {

        String path = String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=%s",
                symbol, key);
        // for ETF and dividend implementation have it where it changes the link based on what class is being called

        RestTemplate restTemplate = new RestTemplate();
        GlobalQuoteWrapper response = restTemplate.getForObject(path, GlobalQuoteWrapper.class);

        Stock stock = response.getGlobalQuote();

        stock.setQuantity(quantity);




        return stock;
    }


}
