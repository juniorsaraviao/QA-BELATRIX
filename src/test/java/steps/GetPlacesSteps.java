package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtensions;

public class GetPlacesSteps {

    public static ResponseOptions<Response> response;
    @Given("^Dado un usuario que desea desea obtener la lista de restaurantes con la misma descripcion para el recurso \"([^\"]*)\"$")
    public void dadoUnUsuarioQueDeseaDeseaObtenerLaListaDeRestaurantesConLaMismaDescripcionParaElRecurso(String url)  {
        response = RestAssuredExtensions.GetOps(url);

    }

    @Then("^deberia listar los restaurantes con la descripcion \"([^\"]*)\"$")
    public void deberiaListarLosRestaurantesConLaDescripcion(String description) {
        BDDStyleMethods.ObtenerCollectionPlaces(description);
        System.out.println("iasdfhisdhfsdhfjkshdfkjdksf");
        System.out.println(response.getBody().asString());
    }
}
