package com.flikendo.F_Diesel_Gas;

import com.flikendo.F_Diesel_Gas.Connection.WebConnection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.flikendo.F_Diesel_Gas.Commons.Constants.*;
import static com.flikendo.F_Diesel_Gas.Commons.Utils.formatData;

/**
 * Date: 03-17-2022
 * Author: Flikendo
 * <p>
 * WebConnectionTest class. Unit tests
 */
@SpringBootTest
class FDieselGasApplicationTests {
    /**
     * Unit test to check if website is up/down
     */
    @Test
    public void isWebUp() {
        WebConnection webConnection = new WebConnection(DEFAULT_URL);
        webConnection.isWebUp();
    }

    /**
     * Unit test to get the data from an URL
     */
    @Test
    public void getDataUrl() {
        WebConnection webConnection = new WebConnection(ALCANIZ_URL);
        String str = webConnection.getDataUrl();

        String stations = formatData(str, FULL_INFO);

        webConnection.storeStations(stations);
    }
}
