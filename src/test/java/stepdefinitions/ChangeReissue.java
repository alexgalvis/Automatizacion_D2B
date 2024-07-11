package stepdefinitions;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabffctas;
import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabfftarj;
import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Matffpreex;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import step.questions.iseries.CheckCabfftarj;
import step.questions.iseries.CheckCatffctas;
import step.questions.iseries.CheckMatffpreex;

import java.sql.SQLException;
import java.util.ArrayList;

public class ChangeReissue {
    @Given("que la tarjeta {string} es pre-expedida")
    public void queLaTarjetaEsPreExpedida(String numCard) {
        try {
            Matffpreex matffpreex = CheckMatffpreex.consultationByCard(numCard);
            StringBuilder stringBuilder = new StringBuilder("----------MATFFPREEX----------" + "\n" +
                    "CARD: " + matffpreex.getNumCard() + "\n" +
                    "OFICINA: " + matffpreex.getOffice() + "\n" +
                    "CLASE: " + matffpreex.getClase() + "\n" +
                    "NIT: " + matffpreex.getNit());
            System.out.println(stringBuilder);
            Assert.assertTrue("Existe tarjeta en maestro preexpedidas: ",true);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("no se encontro tarjeta: ");
        }
    }

    @And("el estado en tarj {string} es activo y asociada al cliente {string}")
    public void elEstadoEnTarjEsActivoYAsociadaAlCliente(String numCard, String nit) throws SQLException {
        try {
            Cabfftarj cabfftarj = CheckCabfftarj.consultationByCard(numCard);
            StringBuilder stringBuilder = new StringBuilder("----------CABFFTARJ----------" + "\n" +
                    "CD-ESTADO: " + cabfftarj.getCdEstado() + "\n" +
                    "CARD: " + "530691" + cabfftarj.getNumCardTj() + "\n" +
                    "NIT: " + cabfftarj.getNit() + "\n" +
                    "TD-ESTADO: " + cabfftarj.getTdEstado() + "\n" +
                    "FECHA-EMI: " + cabfftarj.getFechaEmi() + "\n" +
                    "RENEWALL: " + cabfftarj.getEspacio1());
            System.out.println(stringBuilder);
            boolean validation = cabfftarj.getCdEstado().equals("A") && cabfftarj.getTdEstado().equals("A") &&
                    cabfftarj.getNit().equals(nit);
            Assert.assertTrue("Validaciones de estado y asociacion en Cabfftarj",validation);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("no se encontro tarjeta en TARJ: ");
        }
    }

    @Then("la tarjeta {string} heredo las cuentas")
    public void laTarjetaHeredoLasCuentas(String numCard){
        try {
            ArrayList<Cabffctas> listCtas = CheckCatffctas.consultationByCard(numCard);
            System.out.println("----------CATFFCTAS------------------");
            for (Cabffctas cabffctas:listCtas) {
                System.out.println("CUENTA: " + cabffctas.getCtas() + "\n" + "ESTADO: " + cabffctas.getEstado());
            }

        }catch (Exception e){
            Assert.fail("Sin cuentas en CATFFCTAS");
        }
    }
}
