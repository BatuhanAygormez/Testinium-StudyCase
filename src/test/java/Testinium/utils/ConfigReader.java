package Testinium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.nio.file.Paths;

public class ConfigReader {
    private static Properties prop;
    static {
        try {
            String configLocation = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "app.properties").toString();
            FileInputStream config = new FileInputStream(configLocation);
            prop = new Properties();
            prop.load(config);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static String get(String keyName) {
        return prop.getProperty(keyName);
    }
}
