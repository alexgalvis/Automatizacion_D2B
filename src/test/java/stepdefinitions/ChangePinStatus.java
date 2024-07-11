package stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import step.questions.iseries.CheckMatffestcl;
import step.tasks.UpdateMatffestcl;

import java.sql.SQLException;
import java.util.Date;

public class ChangePinStatus {

    @When("^el cliente (.*) tuvo cambio reciente en la clave$")
    public void ChangeLastUpdateDate (String nit) throws SQLException {
        Date lastUpdate = CheckMatffestcl.lastUpdateDate(nit);
        Date fechaActual = new Date();
        long deltaMilis = Math.abs(fechaActual.getTime() -lastUpdate.getTime());
        long deltaDias = deltaMilis/(1000 * 60 * 60 * 24);
        Assert.assertTrue("La fecha de ultimo cambio de estado es menor a 8 dias", deltaDias < 8);

    }

    @Then("se actualiza la fecha de cambio reciente a {string} al cliente {string}")
    public void seActualizaLaFechaDeCambioRecienteAAlCliente(String lastUpdateDate, String nit) {
        UpdateMatffestcl.UpdateLastUpdateDate(nit,lastUpdateDate);
    }
}
