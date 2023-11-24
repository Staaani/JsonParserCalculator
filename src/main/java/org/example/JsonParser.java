package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Handles parsing of JSON data from both local files and URLs.
 */
public class JsonParser {
    /**
     * Reads JSON data from a specified file.
     *
     * @param filename The path to the file containing JSON data.
     * @return A string containing the JSON data.
     */
    public static String getJSONFromFile(String filename) {
        StringBuilder jsonText = new StringBuilder();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line).append("\n");
            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonText.toString();
    }

    /**
     * Currently Optional
     * Fetches JSON data from a specified URL.
     *
     * @param strUrl The URL from which to fetch the JSON data.
     * @return A string containing the JSON data.
     */
    public static String getJSONFromURL(String strUrl) {
        StringBuilder jsonText = new StringBuilder();

        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line).append("\n");
            }

            is.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonText.toString();
    }
}
