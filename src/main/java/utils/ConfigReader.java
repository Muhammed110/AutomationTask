package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static String get(String key) {
        if (prop == null) {
            prop = new Properties();
            try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
                prop.load(fis);
            } catch (Exception e) {
                throw new RuntimeException("Failed to load config.properties", e);
            }
        }
        return prop.getProperty(key);
    }
}
