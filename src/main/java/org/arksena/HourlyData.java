package org.arksena;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HourlyData {
    @JsonProperty("time")

    private List<String> time;
    @JsonProperty("relative_humidity_2m")
    private List<Integer> relativeHumidity2m;

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Integer> getRelativeHumidity2m() {
        return relativeHumidity2m;
    }

    public void setRelativeHumidity2m(List<Integer> relativeHumidity2m) {
        this.relativeHumidity2m = relativeHumidity2m;
    }

    @Override
    public String toString() {
        return "HourlyData{" +
                "time=" + time +
                ", relativeHumidity2m=" + relativeHumidity2m +
                '}';
    }
}
