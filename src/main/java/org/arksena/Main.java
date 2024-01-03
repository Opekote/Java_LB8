package org.arksena;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://archive-api.open-meteo.com/v1/archive?latitude=50.45&longitude=30.523&start_date=2023-12-27&end_date=2024-01-02&hourly=relative_humidity_2m&daily=temperature_2m_mean,precipitation_sum,wind_speed_10m_max&wind_speed_unit=ms&timezone=auto";
            String responseBody = HttpConnectinClass.sendGetRequest(apiUrl);
            System.out.println(responseBody);
            ObjectMapper objectMapper = new ObjectMapper();


            // Map JSON to DTO
            WeatherForecastDTO weatherDataDTO = objectMapper.readValue(responseBody, WeatherForecastDTO.class);

            // Now you can work with the DTO
            System.out.println("Latitude: " + weatherDataDTO.getLatitude());
            System.out.println("Longitude: " + weatherDataDTO.getLongitude());
            System.out.println("DailyInfo: " + weatherDataDTO.getDaily());
            System.out.println("Elevation: " + weatherDataDTO.getElevation());
            System.out.println("HourlyInfo: " + weatherDataDTO.getHourly());
            System.out.println("ColdestTemp: " + weatherDataDTO.getTop10ColdestTemps());
            System.out.println("WarmestTemp: " + weatherDataDTO.getTop10WarmestTemps());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}