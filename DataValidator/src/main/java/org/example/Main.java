package org.example;

import org.example.api.TemperatureAPI;
import org.json.JSONArray;

public class Main {

    public static void main(String[] args) {
        try {
            // Fetch data from the Temperature API
            TemperatureAPI temperatureAPI = new TemperatureAPI();
            String temperatureData = temperatureAPI.getData();
            JSONArray temperatureJsonData = new JSONArray(temperatureData);

            // Configure and validate temperature data
            String temperatureTimestampField = "timestamp";
            String temperatureValueField = "temperature";
            double temperatureAllowedVariationSpeed = 1.0;

            boolean isTemperatureDataValid = DataValidator.validateData(
                    temperatureJsonData,
                    temperatureTimestampField,
                    temperatureValueField,
                    temperatureAllowedVariationSpeed
            );

            if (isTemperatureDataValid) {
                System.out.println("Temperature data is valid.");
            } else {
                System.out.println("Temperature data contains invalid points.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
