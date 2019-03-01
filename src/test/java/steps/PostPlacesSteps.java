package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtensions;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class PostPlacesSteps {
    public static ResponseOptions<Response> response;
    @Given("^Un post operation para places for \"([^\"]*)\" with body$")
    public void unPostOperationParaPlacesForWithBody(String placeNumber, DataTable table){
        List<List<String>> data = table.raw();

        // set Body
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("id", data.get(1).get(0));
        body.put("name", data.get(1).get(1));
        body.put("description", data.get(1).get(2));


        // set Parameters
        HashMap<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("placeNro", data.get(1).get(0));

        // perform post Operation
        response = RestAssuredExtensions.PostOpsWithBodyAndPathParams(placeNumber, pathParams, body);
    }

    @Then("^Deberia obtener el nombre \"([^\"]*)\"$")
    public void deberiaObtenerElNombre(String name) {
        assertThat(response.getBody().jsonPath().getString("name"), containsString(name));
    }
}
