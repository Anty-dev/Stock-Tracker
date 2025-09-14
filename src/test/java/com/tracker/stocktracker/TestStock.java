package com.tracker.stocktracker;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class TestStock {

    @Test
    void testStock1() {

        Stock apple = new Stock("APPL", 150, 10);
        Stock spy = new ETF("SPY", 620, 2);

        assertEquals("SPY", spy.getSymbol());


        assertEquals(1500, apple.getPrice());
        assertEquals(1240, spy.getPrice());

        assertNotSame(apple, spy);

        assertEquals(2, spy.getQuantity());

        spy.addShares(5);
        spy.removeShares(1);
        assertEquals(6, spy.getQuantity());


    }

    @Test
    void testStock2() {

            RestTemplate restTemplate = new RestTemplate();
            API api = new API();
            String key = api.getKey();

            String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=IBM&apikey=" + key;

            GlobalQuoteWrapper response = restTemplate.getForObject(url, GlobalQuoteWrapper.class);

            Stock stock = response.getGlobalQuote();

            assertEquals("IBM", stock.getSymbol());
            System.out.println(stock.getPrice());
    }

    @Test
    void testStock3() {

        Account acc = new Account("Bill", 10000);

        acc.deposit(5000);
        acc.deposit(5000);
        acc.withdraw(10000);
        assertEquals(10000, acc.getBalance());

        Account acc2 = new Account("Bill", 10000);
        assertNotSame(acc2, acc);

        // note the price arg doesn't matter here as it will be overwritten by the api call value
        Stock ibm = new Stock("IBM", 0, 1);
        acc.Buy(ibm.getSymbol(), ibm.getQuantity(), false);



    }
}
