package step.tasks;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Matffestcl;
import co.com.bancolombia.kioscos.automatizacion.repository.iseries.MatffestclImpl;
import net.serenitybdd.annotations.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateMatffestcl {
    @Step("se actualiza fecha de ultimo cambio")
    public static void UpdateLastUpdateDate(String nit, String lastUpdateDate){
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        try {
            Date fechaDate = formato.parse(lastUpdateDate);
            java.sql.Date sqlDate = new java.sql.Date(fechaDate.getTime());
            MatffestclImpl matffestclImpl = new MatffestclImpl();
            Matffestcl matffestcl = new Matffestcl(sqlDate,nit);
            matffestclImpl.update(matffestcl);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
