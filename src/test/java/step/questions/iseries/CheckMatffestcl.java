package step.questions.iseries;
import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Matffestcl;
import co.com.bancolombia.kioscos.automatizacion.repository.iseries.MatffestclImpl;
import net.serenitybdd.annotations.Step;
import java.sql.SQLException;
import java.util.Date;

public  class CheckMatffestcl {

    @Step("se consulta fecha de ultimo cambio en pin")
    public static Date lastUpdateDate(String nit) throws SQLException {

        MatffestclImpl matffestclImpl = new MatffestclImpl();
        Matffestcl matffestcl = matffestclImpl.ask(nit);
        return matffestcl.getLastUpdate();
    }
}
