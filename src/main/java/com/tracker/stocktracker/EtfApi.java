package com.tracker.stocktracker;

import org.springframework.web.client.RestTemplate;

public class EtfApi extends StockApi{



    public ETF fetch(String symbol, int quantity, boolean isETF) {

        String path = String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=%s",
                symbol, new API().getKey());
        // for ETF  implementation have it where it changes the link based on what class is being called
        String pathTwo = String.format("https://www.alphavantage.co/query?function=ETF_PROFILE&symbol=%s&apikey=%s",
                symbol, new API().getKey());

        RestTemplate restTemplate = new RestTemplate();
        GlobalQuoteWrapper response = restTemplate.getForObject(path, GlobalQuoteWrapper.class);

        Stock stock = response.getGlobalQuote();
        stock.setQuantity(quantity);

        // Note fix the expense ration implementation (Fixed) //

        ETF tempETF = restTemplate.getForObject(pathTwo, ETF.class);
        ETF etf = new ETF(stock.getSymbol(),stock.getPrice(), stock.getQuantity());

        etf.setExpenseRatio(tempETF.getExpenseRatio());


        return etf;
    }
}
