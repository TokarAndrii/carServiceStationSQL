package util;

import java.util.UUID;


public final class StringUtils {


    private StringUtils(){}


    public static String generateRandomToken(int length){

        return UUID.randomUUID().toString().substring(length);
    }
}
