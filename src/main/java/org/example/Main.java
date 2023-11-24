package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static org.example.Calculation.calculateTotalItemPrice;
import static org.example.Formatting.formatPrice;
import static org.example.JsonParser.getJSONFromFile;

/**
 * Main application class responsible for initiating the process of reading JSON data,
 * parsing it, and performing calculations on each item in the JSON array.
 */
public class Main {

    public static void main(String[] args) {
        String jsonData = getJSONFromFile("files/ItemList.json");
        JSONParser parser = new JSONParser();

        try {
            JSONArray itemsArray = (JSONArray) parser.parse(jsonData);

            for (Object itemObj : itemsArray) {
                JSONObject item = (JSONObject) itemObj;
                try {
                    double totalItemPrice = calculateTotalItemPrice(item);
                    System.out.println("Item/GTIN " + item.get("itemId") + "\n" + item.get("itemDescription") + "\nTotal Item Price: \t" + formatPrice(totalItemPrice) + "\n");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error in calculating item price: " + e.getMessage());
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}