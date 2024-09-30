package common;

import java.io.IOException;
import java.util.Properties;

/**
 * Эксперименты с проперти =)
 * <p>
 * Думаю что телефон, сумма и е-майл тут не уместны
 * попробовал ради эксперимента
 */
public class Config {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("test.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static Integer getImplicitTimeOut() {
        return Integer.parseInt(properties.getProperty("implicit.timeout"));
    }

    public static Integer getExplicitTimeOut() {
        return Integer.parseInt(properties.getProperty("explicit.timeout"));
    }

    public static Boolean isClearCookie() {
        return Boolean.valueOf(properties.getProperty("clear.cookie"));
    }

    public static Boolean isHoldBrowser() {
        return Boolean.valueOf(properties.getProperty("hold.browser"));
    }

    public static String getURL() {
        return properties.getProperty("url");
    }

    public static String getTelephoneNumber() {
        return properties.getProperty("telephone.number");
    }

    public static String getSum() {
        return properties.getProperty("sum");
    }

    public static String getEmail() {
        return properties.getProperty("email");
    }
}
