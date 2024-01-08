package org.university;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherStationDTO {
    private double latitude;
    private double longitude;
    private double generationTimeMs;
    private int utcOffsetSeconds;
    private String timezone;
    private String timezoneAbbreviation;
    private double elevation;

    private HourlyData hourly;

    private DailyData daily;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGenerationTimeMs() {
        return generationTimeMs;
    }

    public void setGenerationTimeMs(double generationTimeMs) {
        this.generationTimeMs = generationTimeMs;
    }

    public int getUtcOffsetSeconds() {
        return utcOffsetSeconds;
    }

    public void setUtcOffsetSeconds(int utcOffsetSeconds) {
        this.utcOffsetSeconds = utcOffsetSeconds;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezoneAbbreviation() {
        return timezoneAbbreviation;
    }

    public void setTimezoneAbbreviation(String timezoneAbbreviation) {
        this.timezoneAbbreviation = timezoneAbbreviation;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public HourlyData getHourly() {
        return hourly;
    }

    public void setHourly(HourlyData hourly) {
        this.hourly = hourly;
    }

    public DailyData getDaily() {
        return daily;
    }

    public void setDaily(DailyData daily) {
        this.daily = daily;
    }

    public List<Double> getTop10WarmestTemps() {
        return daily.getTemperature2mMean().stream()
                .filter(Objects::nonNull)
                .sorted((temp1, temp2) -> Double.compare(temp2, temp1)) // Sort in descending order
                .limit(10)
                .collect(Collectors.toList());
    }
    public List<Double> getTop10ColdestTemps() {
        return daily.getTemperature2mMean().stream()
                .filter(Objects::nonNull)
                .sorted()
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "WeatherForecastDTO{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", generationTimeMs=" + generationTimeMs +
                ", utcOffsetSeconds=" + utcOffsetSeconds +
                ", timezone='" + timezone + '\'' +
                ", timezoneAbbreviation='" + timezoneAbbreviation + '\'' +
                ", elevation=" + elevation +
                ", hourly=" + hourly +
                ", daily=" + daily +
                '}';
    }
}
