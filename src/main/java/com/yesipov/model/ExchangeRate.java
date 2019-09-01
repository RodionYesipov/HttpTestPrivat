package com.yesipov.model;

public class ExchangeRate {
    private String currency;
    private String saleRate;

    public ExchangeRate() {
    }

    public ExchangeRate(String currency, String saleRate) {
        this.currency = currency;
        this.saleRate = saleRate;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSaleRate() {
        return saleRate;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "currency='" + currency + '\'' +
                ", saleRate=" + saleRate +
                '}';
    }
}
