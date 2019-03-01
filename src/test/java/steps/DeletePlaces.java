package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.specification.RequestSpecification;

public class DeletePlaces {
    public static RequestSpecification Request;


    @Then("^Se debería eliminar el places con didhco id$")
    public void seDeberíaEliminarElPlacesConDidhcoId() {
        BDDStyleMethods.testDelete();
    }
}
