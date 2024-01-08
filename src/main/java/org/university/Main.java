package org.university;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static WorkWithAPI meteoAPI = new WorkWithAPI();
    static List weatherStationDTOS = new ArrayList<WeatherStationDTO>();
    static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws JsonProcessingException {


        WeatherStation[] stations = new WeatherStation[]{
                new WeatherStation(1, "Kyiv", 50.45, 30.52),
                new WeatherStation(2,"London", 51.5, -0.1),
                new WeatherStation(3,"Warsaw", 52.2, 21),
                new WeatherStation(4,"Lviv", 50, 25),
                new WeatherStation(5, "Paris", 50, 0),
                new WeatherStation(6, "Rome", 40, 15),
                new WeatherStation(7, "Odessa", 46.47, 30.73),
                new WeatherStation(8, "Washington_DC", 38.90, 77.03),
                new WeatherStation(9, "Prague", 50.07, 14.44),
                new WeatherStation(10, "Hamburg", 53.55, 9.99),
                new WeatherStation(11, "Berlin", 52.52, 13.4),
                new WeatherStation(12, "Barcelona", 41.39, 2.17),
                new WeatherStation(13, "Seoul", 37.55, 127),
                new WeatherStation(15, "Tokyo", 35.67, 139.65),
                new WeatherStation(15, "Lublin", 51.24,  22.57)
        };

        for (WeatherStation station: stations){
            String apiResponse = getDataWithExceptionsHandler(String.valueOf(station.latitude()), String.valueOf(station.longitude()), "2023-12-23", "2023-12-23");
            weatherStationDTOS.add(objectMapper.readValue(apiResponse, WeatherStationDTO.class));
        }



        System.out.println(weatherStationDTOS);


    }

    private static String getDataWithExceptionsHandler(String latitude, String longitude, String startDate, String endDate) {
        try {
            String jsonResponse = meteoAPI.getData(latitude, longitude,startDate,endDate);
            System.out.println(jsonResponse);
            return jsonResponse;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}