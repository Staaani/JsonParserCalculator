package org.example;

import org.json.simple.JSONObject;

import static org.example.Formatting.roundAvoid;
import static org.example.Processor.processDiscounts;
import static org.example.Processor.processUnits;

/**
 * Contains methods for calculating various financial aspects of items represented as JSON objects.
 */
public class Calculation {

    /**
     * Calculates the total price for an item after applying units and discounts.
     * Throws IllegalArgumentException if the base price is not in the correct format.
     *
     * @param item The JSON object representing an item.
     * @return The total item price, rounded to 2 decimal places.
     * @throws IllegalArgumentException If the base price is not a Double.
     */
    static double calculateTotalItemPrice(JSONObject item) throws IllegalArgumentException {
        Object basePriceObj = item.get("basePrice");

        // Check if basePrice is not an instance of Double
        if (!(basePriceObj instanceof Double)) {
            throw new IllegalArgumentException("wrong price format");
        }

        double basePrice = (Double) basePriceObj;
        double unitPrice = basePrice * processUnits(item);
        double totalPriceAfterDiscount = unitPrice - (unitPrice * processDiscounts(item) / 100);
        return roundAvoid(totalPriceAfterDiscount, 2);
    }
}
