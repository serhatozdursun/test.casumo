package helpers;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResponseBodyHelper {
    private final Logger log = LogManager.getLogger(ResponseBodyHelper.class);

    public String getResponseAsString() {
        Response response = ApiHelper.getInstance().getResponse();
        if (response == null)
            log.error("Response is empty");
        return response.then().extract().asString();
    }
}
