package step.tasks;

import co.com.bancolombia.kioscos.automatizacion.modelos.iseries.Matffpreex;
import co.com.bancolombia.kioscos.automatizacion.repository.iseries.*;
import net.serenitybdd.annotations.Step;

import java.sql.SQLException;

public class ResetPreIssuedCard {
    @Step("Borrar asociacion de tarjeta en MATFFPREEX")
    public static void updateMatffpreex(String numCard) throws SQLException {
        MatffpreexImpl matffpreexImpl = new MatffpreexImpl();
        matffpreexImpl.update(new Matffpreex(numCard));
    }
    @Step("Eliminar tarjeta del archivo CABFFTARJ")
    public static void deleteCabfftarj(String numCardTj) throws SQLException{
        CabfftarjImpl cabfftarjImpl = new CabfftarjImpl();
        cabfftarjImpl.delete(numCardTj);
    }
    @Step("Eliminar tarjeta del archivo MATFFMDMAE")
    public static void deleteMatffmdmae(String numCard) throws SQLException{
        MatffmdmaeImpl matffmdmaeImpl = new MatffmdmaeImpl();
        matffmdmaeImpl.delete(numCard);
    }

    @Step("Eliminar tarjeta del archivo MATFFASOMD")
    public static void deleteMatffasomd (String numCard) throws SQLException{
        MatffasomdImpl matffasomdImpl = new MatffasomdImpl();
        matffasomdImpl.delete(numCard);
    }
    @Step("Eliminar cuentas asociadas a la tarjeta en CABFFCTAS")
    public static void deleteCabffctas(String numCardTj) throws SQLException{
        CabffctasImpl cabffctasImplc = new CabffctasImpl();
        cabffctasImplc.delete(numCardTj);
    }
}