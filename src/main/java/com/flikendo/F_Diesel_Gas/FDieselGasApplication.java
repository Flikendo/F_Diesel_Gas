package com.flikendo.F_Diesel_Gas;

import com.flikendo.F_Diesel_Gas.Connection.KafkaProtoProducer;
import com.flikendo.F_Diesel_Gas.Connection.WebConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.flikendo.F_Diesel_Gas.Commons.Constants.SEARCH_URL;

@SpringBootApplication
public class FDieselGasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FDieselGasApplication.class, args);

		WebConnection webConnection = new WebConnection(SEARCH_URL);
		webConnection.isWebUp();

		KafkaProtoProducer.fillInProps();
		webConnection.storeFuelStation(webConnection.getDataUrl());
	}

}
