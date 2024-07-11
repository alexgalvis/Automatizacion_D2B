package step.questions.iseries;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Matffpreex;
import co.com.bancolombia.kioscos.automatizacion.repository.iseries.MatffpreexImpl;
import net.serenitybdd.annotations.Step;

public class CheckMatffpreex {
    @Step("consultar tarjeta en maestro de preexpedidas")
    public static Matffpreex consultationByCard(String numCard){
        return new MatffpreexImpl().ask(numCard);
    }
}
