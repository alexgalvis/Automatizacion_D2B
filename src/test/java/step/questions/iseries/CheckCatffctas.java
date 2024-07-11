package step.questions.iseries;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Cabffctas;
import co.com.bancolombia.kioscos.automatizacion.repository.iseries.CabffctasImpl;
import net.serenitybdd.annotations.Step;

import java.sql.SQLException;
import java.util.ArrayList;

public class CheckCatffctas {
    @Step("Se consulta cuentas asociadas a la tarjeta")
    public static ArrayList<Cabffctas> consultationByCard(String numCard) throws SQLException {
        String numCardTj = numCard.substring(numCard.length() - 10);
        return new CabffctasImpl().listar(numCardTj);
    }
}
