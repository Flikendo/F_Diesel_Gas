package com.flikendo.F_Diesel_Gas.Station;

import com.flikendo.F_Diesel_Gas.Commons.Utils;
import com.flikendo.F_Diesel_Gas.Station.Fuel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import static com.flikendo.F_Diesel_Gas.Commons.Constants.*;

/**
 * Date: 05-18-2022
 * Author: Flikendo
 *
 * Represents a fuel station
 */
public class FuelStation {
    private int id;
    private String latitude;
    private String longitude;
    private String address;
    private String margin;
    private String location;
    private String province;
    private String time;
    private String company;
    private String kindSale;
    private long updatedDate; // It is as ID instead of the variable 'id'
    private String price;
    private String logo;
    private List<Fuel> fuels;

    /**
     * Constructor of the class
     */
    public FuelStation(String info) {
        this.fuels = new ArrayList<>();
        splitInfo(info);
    }

    /**
     * Splits the info of fuel station and so that set the variables
     *
     * @param info String with the information
     * @return
     */
    private void splitInfo(String info) {
        Optional
                .ofNullable(info)
                .map(dataInfo -> dataInfo.split(","))
                .ifPresent(infoVector -> {
                            setId(infoVector[0]);
                            setLatitude(infoVector[1]);
                            setLongitude(infoVector[2]);
                            setAddress(infoVector[3]);
                            setMargin(infoVector[5]);
                            setLocation(infoVector[6]);
                            setProvince(infoVector[7]);
                            setTime(infoVector[8]);
                            setCompany(infoVector[9]);
                            setKindSale(infoVector[10]);
                            setUpdatedDate(infoVector[11]);
                            setPrice(infoVector[12]);
                            setLogo(infoVector[13]);
                        }
                );

        Optional
                .of(info)
                .map(dataInfo -> Utils.formatDataPrices(info))
                .map(fuels -> {setFuels(fuels); return null;});

    }

    /**
     * Getters & Setters
     */
    private int getId() {
        return id;
    }

    private void setId(String id) {
        this.id = Integer.parseInt(Utils.formatData(id, REG_EXP_PATTERN_ID));
    }

    private String getLatitude() {
        return latitude;
    }

    private void setLatitude(String latitude) {
        this.latitude = Utils.formatData(latitude, REG_EXP_PATTERN_LAT);
    }

    private String getLongitude() {
        return longitude;
    }

    private void setLongitude(String longitude) {
        this.longitude = Utils.formatData(longitude, REG_EXP_PATTER_LON);
    }

    private String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = Utils.formatData(address, REG_EXP_PATTERN_ADDR);
    }

    private String getMargin() {
        return margin;
    }

    private void setMargin(String margin) {
        this.margin = Utils.formatData(margin, REG_EXP_PATTERN_MARG);
    }

    public String getLocation() {
        return location;
    }

    private void setLocation(String location) {
        // 'Substring' and 'replace' are used since ALCANIZ has a strange character so in order to avoid this
        // characters this way has been development
        String tmp = location.substring(location.indexOf("'"));
        this.location = tmp.replace("'", "");
    }

    private String getProvince() {
        return province;
    }

    private void setProvince(String province) {
        this.province = Utils.formatData(province, REG_EXP_PATTERN_PROV);
    }

    private String getTime() {
        return time;
    }

    private void setTime(String time) {
        this.time = Utils.formatData(time, REG_EXP_PATTERN_TIME);
    }

    private String getCompany() {
        return company;
    }

    private void setCompany(String company) {
        this.company = Utils.formatData(company, REG_EXP_PATTERN_COMP);
    }

    private String getKindSale() {
        return kindSale;
    }

    private void setKindSale(String kindSale) {
        this.kindSale = Utils.formatData(kindSale, REG_EXP_PATTERN_KIND_SALE);
    }

    private long getUpdatedDate() {
        return updatedDate;
    }

    private void setUpdatedDate(String updatedDate) {
        this.updatedDate = Long.parseLong(Utils.formatData(updatedDate, REG_EXP_PATTERN_UPD_DATE));
    }

    private String getPrice() {
        return price;
    }

    private void setPrice(String price) {
        this.price = Utils.formatData(price, REG_EXP_PATTERN_PRICE);
    }

    private String getLogo() {
        return logo;
    }

    private void setLogo(String logo) {
        this.logo = Utils.formatData(logo, REG_EXP_PATTER_LOGO);
    }

    private List<Fuel> getFuels() {
        return fuels;
    }

    private void setFuels(List<Object> fuels) {
        String shortFuelName = "";
        String price = "";
        Pattern regexFuel = Pattern.compile(REG_EXP_PATTERN_FUEL);
        Pattern regexPrice = Pattern.compile(REG_EXP_PATTERN_PRICES);

        for (Object fuel : fuels) {
            shortFuelName = Utils.formatData(fuel.toString(), regexFuel);
            price = Utils.formatData(fuel.toString(), regexPrice);

            this.fuels.add(new Fuel(shortFuelName, price));
        }
    }

    /**
     * Method toString
     * @return string with all value of variables
     */
    @Override
    public String toString() {
        return "FuelStation{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", address='" + address + '\'' +
                ", margin='" + margin + '\'' +
                ", location='" + location + '\'' +
                ", province='" + province + '\'' +
                ", time='" + time + '\'' +
                ", company='" + company + '\'' +
                ", kindSale='" + kindSale + '\'' +
                ", updatedDate=" + updatedDate +
                ", price='" + price + '\'' +
                ", logo='" + logo + '\'' +
                ", fuels=" + fuels +
                '}';
    }
}
