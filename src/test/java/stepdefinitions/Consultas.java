package stepdefinitions;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabffctas;
import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabfftarj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import step.questions.iseries.CheckCabfftarj;
import step.questions.iseries.CheckCatffctas;
import step.tasks.ResetPreIssuedCard;

import java.sql.SQLException;
import java.util.ArrayList;

public class Consultas {

    @When("el numero de tarjeta es {string} en CABFFTARJ")
    public void consultaCabfftarj(String numCard) throws SQLException {
        String numCardTj = numCard.substring(numCard.length() - 10);
        Cabfftarj cabfftarj = CheckCabfftarj.consultationByCard(numCardTj);
        System.out.println(cabfftarj.toString());
    }
    @And("el numero de tarjeta es {string} en CABFFCTAS")
    public void consultaCabffctas(String numCard) throws SQLException {
        ArrayList<Cabffctas> listCtas = CheckCatffctas.consultationByCard(numCard);
        System.out.println("\n****************   CABFFCTAS   ***************");
        System.out.println("Estado\t|Cuenta\t\t|Tarjeta\t\t|clav");
        for (Cabffctas cabffctas:listCtas) {
            System.out.println(cabffctas.toString());
        }
    }
}
