package com.flikendo.F_Diesel_Gas.Connection;

import com.flikendo.F_APIRest_Internet.Connection.APIWebConnection;
import com.flikendo.F_Diesel_Gas.Station.FuelStation;

/**
 * Date: 03-17-2022
 * Author: Flikendo
 *
 * WebConnection class. This class uses F_API_Internet, it is a wrapper.
 */
public class WebConnection {
    private APIWebConnection apiWebConnection;
    private String url;

    /**
     * Constructor of the class
     */
    public WebConnection(String url) {
        this.url = url;
        apiWebConnection = new APIWebConnection(this.url);
    }

    /**
     * Create a web connection. The URL is obtained from constructor class.
     */
    public void isWebUp() {
        apiWebConnection.isWebUp();
    }

    /**
     * Get data from URL
     *
     * @return Data from URL
     */
    public String getDataUrl() {
        return apiWebConnection.getDataUrl();
    }

    /**
     * Stores fuel stations.
     *
     * @param stations the gotten data from URL. It contains the different fuel stations which have to be split
     */
    public void storeFuelStation(String stations) {
        System.out.println("ALL STATIONS: \n" + stations);
        String[] fuelStations = stations.split(";");

        for (String fuelStation : fuelStations) {
            FuelStation station = new FuelStation(fuelStation);
            System.out.println("INFO STATION: \n" + station);

            KafkaProtoProducer.createProto(station);
        }
    }
}
