package steps;

import exeptions.UpperCaseException;
import helpers.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetScenarioSteps {
    private final Logger log = LogManager.getLogger(GetScenarioSteps.class);
    @Given("{string} base url and {int} port")
    public void setUrl(String url, int port) {
        var urlHelper = new UrlHelper();
        urlHelper.addBasePath(url);
        urlHelper.addPortNumber(port);
    }

    @When("Passed {string} as {string} and send the GET request")
    public void passedAndSendTheGETRequest(String value, String key) {
        var pathParamHelper = new PathParameterHelper();
        pathParamHelper.addPathParam(key, value);
        var get = new GetHelper();
        get.getRequest();
    }

    @Then("Respond shouldn't be contains any of the vowels")
    public void respondShouldnTBeContainsAnyOfTheVowels() {
        var response = new ResponseBodyHelper();
        var responseValue = response.getResponseAsString();
        for (char letter : responseValue.toCharArray()){
            if (Character.isUpperCase(letter)) {
                log.error(ApiHelper.getInstance().getResponse().asPrettyString());
                throw new UpperCaseException(letter);
            }
        }
    }
}
