package utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class Parameters {
    private static Parameters instance;
    Properties configProps;
    Properties systemProp;
    protected static final Logger log = LogManager.getLogger(Parameters.class);
    static final String PROP_FILE_NAME = "config.properties";
    private String slackToken;
    private String connectionString;
    private String dbClass;
    private String dbPassword;
    private String dbUser;
    private String webhook;

    public static Parameters getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Parameters();
        }
    }

    private Parameters() {
        try (InputStream is = ClassLoader.getSystemResourceAsStream(PROP_FILE_NAME)) {
            configProps = new Properties();
            configProps.load(is);
        } catch (Exception e) {
            log.error(e);
        } finally {
            log.info("Properties read finished.");
        }
    }

    public String getStringValueOfProp(String propKey) {
        return configProps.getProperty(propKey);
    }

    public Integer getIntegerValueOfProp(String propKey) {
        var stringValue = configProps.getProperty(propKey);
        return stringValue != null ? Integer.parseInt(stringValue) : null;
    }
}