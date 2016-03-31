package util;

import exeption.NoElementFound;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Properties;

public class ConfigData {

    public static String uiMappingFile = "/UIMapping.properties";

    public static String getValFromFile(String key, String fileName) throws NoElementFound {

        Properties properties = new Properties();

        try {
            properties.load(ConfigData.class.getResourceAsStream(uiMappingFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }



/*        System.out.println(key);                //Logo
        System.out.println(partsOfLocators[0]); //cssSelector(
        System.out.println(findMetod);          //cssSelector
        System.out.println(target);             //.ellos.active*/

    // Return By class with appropriate method and target


    public static By ui(String key) throws NoElementFound {

        String[] partsOfLocators = getValFromFile(key, uiMappingFile).split("/");
        String findMethod = partsOfLocators[0].substring(0, partsOfLocators.length - 1);
        String target = partsOfLocators[1];

        if (findMethod.equals("id")) {
            return By.id(target);
        } else {
            if (findMethod.equals("xPath")) {
                return By.xpath(target);
            } else {
                if (findMethod.equals("name")) {
                    return By.name(target);
                } else {
                    if (findMethod.equals("linkText")) {
                        return By.linkText(target);
                    } else {
                        if (findMethod.equals("tagName")) {
                            return By.tagName(target);
                        } else {
                            if (findMethod.equals("className")) {
                                return By.className(target);
                            } else {
                                if (findMethod.equals("cssSelector")) {
                                    return By.cssSelector(target);
                                } else {
                                    return By.partialLinkText(target);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
