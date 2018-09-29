package simCrawler.config;

import java.io.IOException;
import java.util.Properties;

public class MailConfig {
    private static Properties props = new Properties();
    private static final String ACCOUNT = "account";
    private static final String PASSWORD = "password";
    private static final String HOST = "host";
    private static final String RECIEVE = "recieve";
    private static final String HOUR = "hour";
    private static final String MINUTE = "minute";
    private static final String SECOND = "second";
    public static final String CONFIGFILE = "mail.properties";

    static {
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIGFILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getACCOUNT() {
        return props.getProperty(ACCOUNT);
    }

    public static String getPASSWORD() {
        return props.getProperty(PASSWORD);
    }

    public static String getHOST() {
        return props.getProperty(HOST);
    }

    public static String getRECIEVE() {
        return props.getProperty(RECIEVE);
    }

    public static int getHOUR() {
        return Integer.parseInt(props.getProperty(HOUR));
    }

    public static int getMINUTE() {
        return Integer.parseInt(props.getProperty(MINUTE));
    }

    public static int getSECOND() {
        return Integer.parseInt(props.getProperty(SECOND));
    }
}
