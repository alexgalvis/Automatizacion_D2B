package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step.tasks.ScreenMyBD;

import java.util.Map;

public class ChangeSreenText {

    private ScreenMyBD scre;
    @When("^se cargan pantallas de la ruta \"([^\"]*)\" y flujo \"([^\"]*)\"$")
    public void loadScreen(String ruta, int idFlujo) {
        ScreenMyBD loadScreens = new ScreenMyBD();
        loadScreens.load(ruta,idFlujo);
        this.scre = loadScreens;
    }

    @Then("se listan pantallas guardadas")
    public void printScreen() {
        scre.printScreen();
    }

    @When("^se listan las pantallas del flujo \"([^\"]*)\"$")
    public void seListanLasPantallasDelFlujo(Long idFlujo) {
        ScreenMyBD screenMyBD = new ScreenMyBD();
        screenMyBD.checkScreen(idFlujo);
        screenMyBD.printScreen();


    }
}
