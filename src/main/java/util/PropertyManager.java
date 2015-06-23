package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Admin on 23.06.2015.
 */
public class PropertyManager {
    private final Properties properties;

    public PropertyManager(String fileName) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
