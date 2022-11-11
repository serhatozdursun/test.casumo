package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class PathParameterHelper {

    private final Logger log = LogManager.getLogger(PathParameterHelper.class);
    private static final String LOG_INFO = "{} = {} added to request as path param";

    /**
     * Add path param to request
     *
     * @param key   is param key as string.
     * @param value is param value as string.
     */
    public void addPathParam(String key, String value) {
        ApiHelper.getInstance().getRequestSpecification().pathParam(key, value);
        log.info(LOG_INFO, key, value);
    }

}
