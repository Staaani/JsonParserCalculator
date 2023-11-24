package org.example;

import org.json.simple.JSONObject;

/**
 * Processes various aspects of an item represented as a JSON object, such as units and discounts.
 */
public class Processor {

    /**
     * Processes the units of an item from its JSON representation.
     * Defaults to 1 if units are not specified.
     *
     * @param item The JSON object representing an item.
     * @return The number of units.
     * @throws IllegalArgumentException If the units value is invalid.
     */
    public static long processUnits(JSONObject item) throws IllegalArgumentException {
        long units;
        if (item.containsKey("units")) {
            units = (Long) item.get("units");
        } else {
            units = 1;
        }
        return units;
    }
    /**
     * Processes the discount percentage of an item from its JSON representation.
     * Defaults to 0.0 if a discount is not specified.
     *
     * @param item The JSON object representing an item.
     * @return The discount percentage.

     */
    public static Double processDiscounts(JSONObject item) {
        Double discount;
        if (item.containsKey("percentageDiscount")) {
            discount = (Double) item.get("percentageDiscount");
        } else {
            discount = 0.0;
        }
        return discount;
    }
}
