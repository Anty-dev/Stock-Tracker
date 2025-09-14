package com.tracker.stocktracker;

import com.fasterxml.jackson.annotation.JsonProperty;

// Since alpha vantage's api returns the stock data nested within a Global Quote object we need to properly deserialize this by making a wrapper
// class that maps to the outer JSON structure. This allows Jackson to extract the nested "Global Quote" object and
// populate our Stock POJO with the corresponding values

public class GlobalQuoteWrapper {

    @JsonProperty("Global Quote")
    private Stock globalQuote;

    public Stock getGlobalQuote() {
        return globalQuote;
    }

    public void setGlobalQuote(Stock globalQuote) {
        this.globalQuote = globalQuote;
    }

}
