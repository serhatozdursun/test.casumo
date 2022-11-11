package base;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.Parameters;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    private static boolean isFailed = false;
    private static List<String> failedScenarios;

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @After
    public static void after(Scenario scenario) {
        if (!isFailed && scenario.isFailed())
            isFailed = true;
        if (isFailed) {
            failedScenarios = new ArrayList<>();
            failedScenarios.add(scenario.getName());
        }
    }

    @AfterAll
    public static void sendSlackMessage() {
        if (isFailed)
            sendSlackMessageWithWebHook(createFailedText());
        else
            sendSlackMessageWithWebHook(createSuccessText());
    }

    private static String createFailedText() {
        return """
                Some of the test cases are failed
                \n<https://reports.cucumber.io/report-collections/d69154d2-29b6-43f2-877e-daaeb8f15461|*Click for report*>
                \n *Failed scenarios is below:* \n
                """;
    }

    private static String createSuccessText() {
        return "Test completed successful :white_check_mark:";
    }


    public static void sendSlackMessageWithWebHook(String text) {
        JSONObject body = new JSONObject();
        JSONArray attachments = new JSONArray();
        if (!failedScenarios.isEmpty()) {
            for (String name : failedScenarios) {
                attachments.put(new JSONObject().put("text", name));
            }
        }
        body.put("text", text);
        body.put("attachments", attachments);

        try {
            Response response = RestAssured.given()
                    .header("Content-type", "application/json")
                    .baseUri(Parameters.getInstance().getStringValueOfProp("webhook"))
                    .body(new String(String.valueOf(body).getBytes(StandardCharsets.UTF_8)))
                    .post();
            if (response.statusCode() != 200) {
                log.warn("Slack message couldn't send, please check your webhook is active?");
                log.warn(response.asPrettyString());
            }
        } catch (Exception e) {
            log.warn(" Unexpected error occurred when trying send the slack message." + "Error message is:{}", e.getMessage());
        }
    }
}
