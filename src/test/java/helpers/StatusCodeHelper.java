package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class StatusCodeHelper extends ResponseBodyHelper {

    private final Logger log = LogManager.getLogger(StatusCodeHelper.class);

    /**
     * checks if the status code is the same as the requested status code.
     *
     * @param statusCode is requested status code
     */
    public void checkStatusCode(int statusCode) {
        ApiHelper.getInstance().getResponse().then().statusCode(statusCode);
        log.info("Status code is {}", statusCode);
    }

}
