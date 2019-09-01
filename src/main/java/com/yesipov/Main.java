package com.yesipov;

import com.google.gson.Gson;
import com.yesipov.model.Response;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static String checkValidDate(String dateIn) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(INPUT_DATE_FORMAT);
        dateFormat.setLenient(false);
        String messageForClient = null;
        try {
            Date date = dateFormat.parse(dateIn);
            if(date.after(new Date())){
                messageForClient = "You have entered a date from the future!";
            }
            return messageForClient;
        } catch (ParseException e) {
            messageForClient = "Entered invalid date";
            return messageForClient;
        }
    }

    private static final String URL = "https://api.privatbank.ua/p24api/exchange_rates?json&date=";
    private static final String INPUT_DATE_FORMAT = "dd.MM.yyyy";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a date in format DD.MM.YYYY:");
        String dateIn = scanner.nextLine();

        if (checkValidDate(dateIn) != null) {
            throw new Exception(checkValidDate(dateIn));
        }

        String json = HttpUtil.sendRequest(URL + dateIn, null, null);
        Gson gson = new Gson();
        Response response = gson.fromJson(json, Response.class);
        Map<String, String> exchangeMap = new HashMap<>();

        for (int i = 0; i < response.getExchangeRate().size(); i++) {
            exchangeMap.put(
                    response.getExchangeRate().get(i).getCurrency(),
                    response.getExchangeRate().get(i).getSaleRate()
            );
        }

        String usdRate = exchangeMap.get("USD");
        if (usdRate == null) {
            System.out.println("No exchange rate for this date");
        } else {
            System.out.println("The exchange rate of UAH to USD for date = " + dateIn + " is " + usdRate);
        }
    }

}
