package util;

/**
 * Created by tokar on 26.03.16.
 */
public class ClassNameUtil {
    public ClassNameUtil() {
    }

    public static String getCurrentClassName() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            return e.getStackTrace()[1].getClassName();
        }

    }
}
