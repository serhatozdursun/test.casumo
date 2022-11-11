package helpers;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetHelper {
    private final Logger log = LogManager.getLogger(GetHelper.class);

    /**
     * Create a get request and update ApiHelper class' response object.
     */
    public void getRequest() {
        Response response = ApiHelper.getInstance()
                .getRequestSpecification()
                .urlEncodingEnabled(false)
                .get()
                .then()
                .extract()
                .response();
        ApiHelper.getInstance().setResponse(response);
        ApiHelper.getInstance().defineNewRequest();
        log.info("Get request sent");
    }

}
