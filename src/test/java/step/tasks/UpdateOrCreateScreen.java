package step.tasks;

import co.com.bancolombia.kioscos.automatizacion.modelos.PantallaTextKio;
import co.com.bancolombia.kioscos.automatizacion.repository.otros.PantallaKioImpl;
import co.com.bancolombia.kioscos.automatizacion.repository.otros.Repositorio;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionBaseDatos;
import net.serenitybdd.annotations.Step;


import java.sql.Connection;
import java.sql.SQLException;

public class UpdateOrCreateScreen {
    @Step("se hace el cambio")
    public static Boolean updateScreen (Long id,String text){
        try (Connection conn = ConnectionBaseDatos.getInstance()){
            Repositorio<PantallaTextKio> repositorio = new PantallaKioImpl();
            PantallaTextKio pantallaTextKio = new PantallaTextKio(id);
            pantallaTextKio.setText(text);
            repositorio.guardar(pantallaTextKio);;
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
