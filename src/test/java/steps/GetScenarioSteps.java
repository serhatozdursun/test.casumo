package steps;

import exeptions.UpperCaseException;
import helpers.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<Character> list = new ArrayList<>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('A');
            add('E');
            add('I');
            add('O');
        }};

        var responseValue = response.getResponseAsString().chars().mapToObj(i-> (char) i);
        var isContainsVowels = responseValue.anyMatch(i-> list.contains(i));
        assertFalse("The response include vowels: "+response.getResponseAsString(),isContainsVowels);
    }

    @Then("Check status code {int}")
    public void checkStatusCode(int status) {
        new StatusCodeHelper().checkStatusCode(status);
    }
}
