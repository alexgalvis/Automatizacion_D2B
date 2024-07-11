package stepdefinitions;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabffctas;
import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabfftarj;
import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Matffpreex;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import step.questions.iseries.CheckCabfftarj;
import step.questions.iseries.CheckCatffctas;
import step.questions.iseries.CheckMatffpreex;

import java.util.ArrayList;

public class ChangePreissued {
    @When("la tarjeta {string} no tiene cliente asociado en MATFFPREEX")
    public void laTarjetaNoTieneClienteAsociadoEnMATFFPREEX(String numCard) {
        try {
            Matffpreex matffpreex = CheckMatffpreex.consultationByCard(numCard);
            Assert.assertEquals("La tarjeta no tiene asociado cliente", "0", matffpreex.getNit());
            System.out.println(matffpreex.getOffice() + " Num tarjeta: " + matffpreex.getNumCard());
        }catch (Exception e){
            Assert.fail("No existe tarjeta en MATFFPREEX");
            e.printStackTrace();
        }
    }

    @And("la tarjeta {string} no existe en CABFFTARJ")
    public void laTarjetaNoExisteEnCABFFTARJ(String numCard) {
        try {
            Cabfftarj cabfftarj = CheckCabfftarj.consultationByCard(numCard);
            Assert.fail("La tarjeta existe en maestro de tarjetas");
        }catch (Exception e){
            Assert.assertTrue("No existe en maestro de tarjetas", true);
        }


    }

    @And("la tarjeta {string} no existe en MATFFMDMAE")
    public void laTarjetaNoExisteEnMATFFMDMAE(String arg0) {
    }

    @And("la tarjeta {string} no tiene asociadas cuentas en CABFFCTAS")
    public void laTarjetaNoTieneAsociadasCuentasEnCABFFCTAS(String numCard) {
        try {
            ArrayList<Cabffctas> listCtas = CheckCatffctas.consultationByCard(numCard);
            if (listCtas.size() > 0){
                System.out.println("----------CATFFCTAS------------------");
                for (Cabffctas cabffctas:listCtas) {
                    System.out.println("CUENTA: " + cabffctas.getCtas() + "\n" + "ESTADO: " + cabffctas.getEstado());
                }
                Assert.fail("La tarjeta tiene asociadas cuentas en CABFFCTAS");
            }

        }catch (Exception e){
            Assert.assertTrue("La tarjeta no tiene asociadas cuentas en CABFFCTAS",true);
        }
    }
}
