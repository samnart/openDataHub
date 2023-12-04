package org.example.api;

public class TemperatureAPI extends SimpleHttpClient{

    private final String BASE_URL = "https://tourism.opendatahub.com/v1/Weather?";

    private SimpleHttpClient httpClient; // need to resolve this **simpleHttpClient

    public TemperatureAPI() {
        httpClient = new SimpleHttpClient(); //
    }

    public String getData() throws Exception {
        return httpClient.get(BASE_URL + "temperature");
    }
}
