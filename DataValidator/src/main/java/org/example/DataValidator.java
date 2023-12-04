package org.example;

import org.json.JSONObject;
import org.json.JSONArray;

public class DataValidator {

    public static boolean validateData(JSONArray jsonData, String timestampField, String valueField, double allowedVariationSpeed) {
        for (int i = 1; i < jsonData.length(); i++) {
            JSONObject currentDataPoint = jsonData.getJSONObject(i);
            JSONObject previousDataPoint = jsonData.getJSONObject(i - 1);

            long currentTimestamp = currentDataPoint.getLong(timestampField);
            long previousTimestamp = previousDataPoint.getLong(timestampField);

            double currentValue = currentDataPoint.getDouble(valueField);
            double previousValue = previousDataPoint.getDouble(valueField);

            double timeDifferenceInSeconds = (currentTimestamp - previousTimestamp) / 1000.0;
            double valueDifference = Math.abs(currentValue - previousValue);
            double changeSpeed = valueDifference / timeDifferenceInSeconds;

            if (changeSpeed > allowedVariationSpeed) {
                return false; // Invalid data
            }
        }
        return true; // All data points are valid
    }
}
