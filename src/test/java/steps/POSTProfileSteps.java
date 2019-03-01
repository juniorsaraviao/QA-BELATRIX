package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtensions;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class POSTProfileSteps {
    public static ResponseOptions<Response> response;

    @Given("^I Perform POST operation for \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationForWithBody(String profileNumber, DataTable table) {
        List<List<String>> data = table.raw();

        // set Body
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("id", data.get(1).get(1));
        body.put("name", data.get(1).get(0));

        // set Parameters
        HashMap<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("profileNo", data.get(1).get(1));

        // perform post Operation
        response = RestAssuredExtensions.PostOpsWithBodyAndPathParams(profileNumber, pathParams, body);
    }

    @Then("^I should see the body has name as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyHasNameAs(String name) {
         assertThat(response.getBody().jsonPath().getString("name"), containsString(name));
    }
}
