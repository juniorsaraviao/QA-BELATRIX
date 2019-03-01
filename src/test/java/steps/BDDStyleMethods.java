package steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;


public class BDDStyleMethods {

    public static void SimpleGetPOST(String postNumber, String authorName) {
        given()
                .contentType(ContentType.JSON).
        when()
                .get(String.format("http://localhost:3000/posts/%s", postNumber)).
        then()
                .body("author", is(authorName)).log().body();
    }

    public static void ObtenerCollectionPlaces(String description) {
        given()
                .contentType(ContentType.JSON).
        when()
                .get("http://localhost:3000/places/").
        then()
                .body(containsString(description))
                .log().body();

    }

    public static void ObtenerCollectionAuthors(String Author1, String Author2, String Author3) {
        given()
                .contentType(ContentType.JSON).
                when()
                .get("http://localhost:3000/posts/").
                then()
                .body("author", containsInAnyOrder(Author1, Author2, Author3));
    }

    public static void ObtenerGetConParametro(String Parametro) {
        given()
                .contentType(ContentType.JSON).
        with()
                .pathParam("post", Parametro).
        when()
                .get("http://localhost:3000/posts/{post}").
        then()
                .body("author", containsString("Juan Bryan Estrada Acosta"));
    }

    public static void ObtenerGetConParametroQuery(String ParametroQuery) {
        given()
                .contentType(ContentType.JSON)
                .queryParam("id", ParametroQuery).
        when()
                .get("http://localhost:3000/posts/").
        then()
                .body("author", hasItem("Belatrix"));
    }

    public static void RealizarPOSTConBodyParam() {
        HashMap<String, String> ContenidoPOST = new HashMap<String, String>();
        ContenidoPOST.put("id", "5");
        ContenidoPOST.put("title", "Testing POST");
        ContenidoPOST.put("author", "Estudiantes");

        given()
                .contentType(ContentType.JSON).
        with()
                .body(ContenidoPOST).
        when()
                .post("http://localhost:3000/posts/").
        then()
                .body("id", containsString("5")).statusCode(201);
    }


    public static void testDelete(){
        given()
                .contentType(ContentType.JSON).
        when()
                .delete("http://localhost:3000/places/1").
        then()
                .header("Expires", equalTo("-1"));
    }
}
