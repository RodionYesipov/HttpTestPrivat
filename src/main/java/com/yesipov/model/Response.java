package com.yesipov.model;

import java.util.Date;
import java.util.List;

public class Response {
    String date;
    List<ExchangeRate> exchangeRate;

    public Response() {
    }

    public Response(String date, List<ExchangeRate> exchangeRate) {
        this.date = date;
        this.exchangeRate = exchangeRate;
    }

    public String getDate() {
        return date;
    }

    public List<ExchangeRate> getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "Response{" +
                "date='" + date + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
