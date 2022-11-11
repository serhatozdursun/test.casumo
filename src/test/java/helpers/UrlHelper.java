package helpers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UrlHelper {

    private final Logger log = LogManager.getLogger(UrlHelper.class);

    public void addBaseUrl(String baseUrl) {
        ApiHelper.getInstance().getRequestSpecification().baseUri(baseUrl);
        log.info("{} added as a base url", baseUrl);
    }

    public void addBasePath(String endpoint) {
        ApiHelper.getInstance().getRequestSpecification().basePath(endpoint);
        log.info("{} added as a base path", endpoint);
    }

    public void addPortNumber(int port){
        ApiHelper.getInstance().getRequestSpecification().port(port);
        log.info("{} added as a port", port);
    }
}
