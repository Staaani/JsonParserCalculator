package org.example;

/**
 * Provides utility methods for formatting and rounding numerical values.
 */
public class Formatting {

    /**
     * Rounds a double value to a specified number of decimal places.
     *
     * @param value  The value to be rounded.
     * @param places The number of decimal places to round to.
     * @return The rounded value.
     */
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    /**
     * Formats a double value to a string with two decimal places.
     *
     * @param value The value to be formatted.
     * @return A string representation of the value with two decimal places.
     */
    public static String formatPrice(double value) {
        return String.format("%.2f", value);
    }
}
