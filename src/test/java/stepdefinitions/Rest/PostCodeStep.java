package stepdefinitions.Rest;

import co.com.bancolombia.kioscos.automatizacion.modelos.rest.BasicInformation;
import co.com.bancolombia.kioscos.automatizacion.modelos.rest.Data;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.rest.SerenityRest;

import static co.com.bancolombia.kioscos.automatizacion.utils.ConstantApi.*;
import static net.serenitybdd.rest.SerenityRest.*;

public class PostCodeStep extends UIInteractions {
    @Given("que tengo la {string}, {string} y la {string}")
    public void givenJsonApi(String cedula, String tipDoc, String operacion){
        SerenityRest.given().baseUri(BASE_URI_MOCK.toString())
                .basePath(BASE_PATH_MDM + operacion)
                .body(new BasicInformation(new Data(tipDoc,cedula)), ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("client-id",CLIENT_ID_MDM.toString())
                .header("client-secret",CLIENT_SECRET_MDM.toString())
                .header("message-id",MESSAGE_ID.toString());
    }
    @When("realizo la solicitud POST a APIs MDM")
    public void whenJsonApi(){
        System.out.println(getDefaultBasePath());
        when().post().statusCode();
    }
    @Then("el resultado es 200 OK")
    public void thenJsonApi(){
        then().statusCode(200);
        System.out.println("Response 200 OK");
    }
}
