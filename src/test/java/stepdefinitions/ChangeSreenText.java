package stepdefinitions;

import co.com.bancolombia.kioscos.automatizacion.modelos.BD.PantallaTextKio;
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

    @When("^se modifican pantallas \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void seModificanPantallas(Long id, String text, double tol, int idFlujo) {
        text = text.replace(" ","");
        //text = "\n" + text;
        ScreenMyBD screenMyBD = new ScreenMyBD();
        PantallaTextKio pantallaTextKio = new PantallaTextKio(text,tol,idFlujo);
        pantallaTextKio.setId(id);
        screenMyBD.updateScreen(pantallaTextKio);
    }

    @When("^se crea nueva pantalla con Tolerancia \"([^\"]*)\", idFlujo \"([^\"]*)\" y \"([^\"]*)\"$")
    public void seCreaNuevaPantallaConToleranciaIdFlujoY(double tol, int idFlujo, String text) {
        text = text.replace(" ","");
        //text = "\n" + text;
        ScreenMyBD screenMyBD = new ScreenMyBD();
        screenMyBD.guardarMyBD(new PantallaTextKio(text,tol,idFlujo));
        this.scre = screenMyBD;
    }

    @When("^se elimina pantalla con ID: \"([^\"]*)\"$")
    public void seEliminaPantallaConID(Long idPantalla) {
        ScreenMyBD screenMyBD = new ScreenMyBD();
        screenMyBD.deleteScreen(idPantalla);
    }
}
