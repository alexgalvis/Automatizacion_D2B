package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import step.tasks.ResetPreIssuedCard;

import java.sql.SQLException;

public class ResetCardReissue {
    @Given("que la tarjeta {string} fue reexpedida se restablece")
    public void ResetCardReissues(String numCard){
        String numCardTj = numCard.substring(numCard.length() - 10);
        try {
            ResetPreIssuedCard.updateMatffpreex(numCard);
            ResetPreIssuedCard.deleteCabfftarj(numCardTj);
            ResetPreIssuedCard.deleteMatffmdmae(numCard);
            ResetPreIssuedCard.deleteMatffasomd(numCard);
            ResetPreIssuedCard.deleteCabffctas(numCardTj);
        }catch (SQLException e){
            e.printStackTrace();
            Assert.fail("no se completo el proceso...");
        }

    }
}
