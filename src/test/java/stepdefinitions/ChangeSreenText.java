package stepdefinitions;

import step.tasks.UpdateOrCreateScreen;
import io.cucumber.java.en.When;

public class ChangeSreenText {

    @When("el {string} de la pantalla el texto es {string}")
    public void elDeLaPantallaElTextoEs(String id, String text) {
        Long Id = Long.valueOf(id);
        Boolean resul = UpdateOrCreateScreen.updateScreen(Id,text);

        // Aserción para verificar que el resultado es verdadero
        assert resul;
    }

}
