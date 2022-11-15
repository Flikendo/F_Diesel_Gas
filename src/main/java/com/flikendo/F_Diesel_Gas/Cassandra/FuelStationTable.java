package com.flikendo.F_Diesel_Gas.Cassandra;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table
public class FuelStationTable {
    // Identifier
    @PrimaryKey
    private UUID id;
    // Name of the business
    private String business;
    // Address of the business
    private String address;
    // Location of the business
    private String location;
    // Date of the info
    private Date date;
    // Price of the fuel
    private String price;

    /**
     * Constructor
     */
    public FuelStationTable(String business, String address, String location, Date date, String price) {
        this.business = business;
        this.address = address;
        this.location = location;
        this.date = date;
        this.price = price;
    }

    /**
     * Getters
     */
    public UUID getId() {
        return id;
    }

    public String getBusiness() {
        return business;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }
}
