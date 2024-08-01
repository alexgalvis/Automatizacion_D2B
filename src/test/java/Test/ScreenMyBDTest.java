package Test;

import co.com.bancolombia.kioscos.automatizacion.modelos.BD.PantallaTextKio;
import org.junit.Test;
import step.tasks.ScreenMyBD;

public class ScreenMyBDTest {
    @Test
    public void changeScreen (){
        Long id = 38L;
        double tolerancia = 0.8;
        int idFlujo = 8;
        String text = "\nBancolombia\n" +
                "Rutinasparareexpedicióndetarjetas\n" +
                "AgregartarjetasVercontadores\n" +
                "Limpiargavetade\n" +
                "rechazo\n" +
                "VolverSalir";

        PantallaTextKio pantallaTextKio = new PantallaTextKio(text,tolerancia,idFlujo);
        pantallaTextKio.setId(id);
        ScreenMyBD screenMyBD = new ScreenMyBD();
        screenMyBD.updateScreen(pantallaTextKio);
        screenMyBD.printScreen();
    }
}
