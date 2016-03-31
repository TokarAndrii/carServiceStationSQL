package util;

import org.eclipse.core.runtime.Assert;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROPERTY_FILE = "/home/tokar/IdeaProjects/carServiceStation/carServiceStation/src/main/resources/application.properties";

    public static String loadProperty(String name) {

        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(PROPERTY_FILE));
        } catch (IOException e) {
            org.testng.Assert.fail("Incorrect property name - " + name);
        }

        String value = "";
        if (name!=null){
            value= props.getProperty(name);
        }



        return value;
    }

}
