package step.questions.iseries;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabfftarj;
import co.com.bancolombia.kioscos.automatizacion.repository.iseries.CabfftarjImpl;
import net.serenitybdd.annotations.Step;

import java.sql.SQLException;

public class CheckCabfftarj {
    @Step("Consulta de tarjeta reexpedida en maestro de tarjetas")
    public static Cabfftarj consultationByCard(String numCard) throws SQLException {
        String numCardTj = numCard.substring(numCard.length() - 10);
        return new CabfftarjImpl().ask(numCardTj);
    }
}
