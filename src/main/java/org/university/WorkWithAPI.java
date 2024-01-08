package org.university;

import java.io.IOException;


import lombok.AllArgsConstructor;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;


@AllArgsConstructor
public class WorkWithAPI {
    private final String apiURL = "https://archive-api.open-meteo.com/v1/archive?";


    public String doGetRequest(String parametrizedURL) throws IOException, ParseException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(parametrizedURL);
            httpGet.addHeader("Content-Type", "application/json");

            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                HttpEntity responseBody = response.getEntity();
                return EntityUtils.toString(responseBody);
            }
        }
    }

    public String buildUrl(String latitude, String longitude, String startDate, String endDate) {
        String resultUrl = apiURL + "latitude=" + latitude + "&longitude=" + longitude + "&start_date=" + startDate
                + "&end_date=" + endDate + getDataFormatQueryParam();

        return resultUrl;
    }

    protected String getData(String latitude, String longitude, String startDate, String endDate) throws IOException, ParseException {
        String urlToUse = buildUrl(latitude, longitude, startDate, endDate);
        return doGetRequest(urlToUse);
    }


    private String getDataFormatQueryParam(){
        return "&hourly=relative_humidity_2m&daily=temperature_2m_mean,precipitation_sum,wind_speed_10m_max&timeformat=unixtime";
    }
}


