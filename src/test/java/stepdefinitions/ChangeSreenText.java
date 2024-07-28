package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step.tasks.LoadScreens;

import java.util.Map;

public class ChangeSreenText {
    private Map<Long, String> screens;
    @When("^se cargan pantallas de la ruta \"([^\"]*)\" y flujo \"([^\"]*)\"$")
    public void loadScreen(String ruta, int idFlujo) {
        LoadScreens loadScreens = new LoadScreens();
        loadScreens.load(ruta,idFlujo);
        this.screens = loadScreens.getTextScreen();
    }

    @Then("se listan pantallas guardadas")
    public void printScreen() {
        for (Map.Entry<Long, String> entry : screens.entrySet()) {
            Long key = entry.getKey();
            String value = entry.getValue();
            System.out.println("----------------" + key + "-----------------------------");
            System.out.println(value + "\n");
        }
    }
}
