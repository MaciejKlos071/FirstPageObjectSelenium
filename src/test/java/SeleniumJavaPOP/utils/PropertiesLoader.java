package SeleniumJavaPOP.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static String loadPropertier(String propertyName) throws IOException {

        InputStream inputStrem = new FileInputStream("src/test/resources/config.properties");
        Properties properties = new Properties();
        properties.load(inputStrem);

        return properties.getProperty(propertyName);

    }
}
