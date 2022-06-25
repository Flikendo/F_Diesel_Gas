package com.flikendo.F_Diesel_Gas.Commons;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.flikendo.F_Diesel_Gas.Commons.Constants.PRICES;

/**
 * Date: 05-23-2022
 * Author: Flikendo
 * <p>
 * Commons methods used in different classes
 */
public class Utils {
    /**
     * Takes the data from URL then look for the regex in whole data and this method only get the part of the data which
     * match with the pattern. E.g: 'Location', 'Price',
     * and so on
     *
     * @param data  string which is going to be processed
     * @param regex RegEx used to get useful data
     * @return String which represents the useful data
     */
    public static String formatData(String data, Pattern regex) {
        Matcher mtc = regex.matcher(data);
        String station = "";

        while (mtc.find()) {
            station = mtc.group();
        }

        return station;
    }

    /**
     * It finds the RegEx in the String, this method is just used to find the fuels and its prices
     * '"4":{"combustible_corto":"GA","precio":1.905,"fecha":1653256800},'
     *
     * @param data  string to be analyzed
     * @return List with all matches
     */
    public static List<Object> formatDataPrices(String data) {
        Matcher mtc = PRICES.matcher(data);
        List<Object> fuels = new ArrayList<>();

        while (mtc.find()) {
            fuels.add(mtc.group());
        }
        return fuels;
    }
}
