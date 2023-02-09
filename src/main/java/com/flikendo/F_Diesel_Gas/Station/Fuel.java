package com.flikendo.F_Diesel_Gas.Station;

/**
 * Date: 03-18-2022
 * Author: Flikendo
 *
 * This class is a characteristic of FuelStation
 */
public class Fuel {
    private String shortFuelName;
    private String price;

    /**
     * Constructor of the class
     *
     * @param shortFuel It is the short form of each kind of fuel e.g: SP95, SP98,... which is in the fuel station
     * @param price The price of each kind of fuel which is in the fuel station
     */
    public Fuel(String shortFuel, String price) {
        this.shortFuelName = shortFuel;
        this.price = price;
    }

    /**
     * Method toString
     *
     * @return string with all value of variables
     */
    @Override
    public String toString() {
        return "Fuel{" +
                "shortFuel='" + shortFuelName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
