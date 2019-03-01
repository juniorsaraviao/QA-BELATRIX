package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtensions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class GetPostSteps {

    public static ResponseOptions<Response> response;

    @Given("^Un usuario desea realizar una operacion GET para el recurso \"([^\"]*)\"$")
    public void unUsuarioDeseaRealizarUnaOperacionGETParaElRecurso(String url) {
        response = RestAssuredExtensions.GetOps(url);
    }

    @When("^realiza una operacion GET para el ID \"([^\"]*)\" y el Nombre \"([^\"]*)\"$")
    public void realizaUnaOperacionGETParaElIDYElNombre(String postNumber, String authorName) {
        //BDD STYLES (BDDStyleMethods)
        //BDDStyleMethods.SimpleGetPOST(postNumber, authorName);
    }

    @Then("^deberia ver el nombre del autor como \"([^\"]*)\"$")
    public void deberiaVerElNombreDelAutorComo(String arg0) {
        assertThat(response.body().jsonPath().getString("author"), containsString("Belatrix"));
    }

    @Then("^Deberia ver el nombre de los Autores \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void deberiaVerElNombreDeLosAutores(String Author1, String Author2, String Author3) {
        BDDStyleMethods.ObtenerCollectionAuthors(Author1, Author2, Author3);
    }

    @Then("^deberia poder ver y comprobar el parametro para la operacion \"([^\"]*)\"$")
    public void deberiaPoderVerYComprobarElParametroParaLaOperacion(String Parametro) {
        BDDStyleMethods.ObtenerGetConParametro(Parametro);
    }


    @Then("^deberia poder ver y comprobar el parametro Query para la operacion \"([^\"]*)\"$")
    public void deberiaPoderVerYComprobarElParametroQueryParaLaOperacion(String QueryParam) {
        BDDStyleMethods.ObtenerGetConParametroQuery(QueryParam);
    }

    @Given("^Un usuario desea realizar una operacion POST$")
    public void unUsuarioDeseaRealizarUnaOperacionPOST() {

    }

    @Then("^deberia poder insertar y compropar que los datos esten ingresados$")
    public void deberiaPoderInsertarYComproparQueLosDatosEstenIngresados() {
        BDDStyleMethods.RealizarPOSTConBodyParam();
    }

}
