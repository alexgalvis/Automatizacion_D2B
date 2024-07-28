package co.com.bancolombia.kioscos.automatizacion.repository.otros;

import co.com.bancolombia.kioscos.automatizacion.modelos.BD.CasoPruebaKio;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class CasosPruebaImpl implements Repositorio<CasoPruebaKio>{

    private Connection getConnection() throws SQLException {
        return ConnectionBaseDatos.getInstance();
    }

    @Override
    public Long insert(CasoPruebaKio casoPruebaKio) {
        return null;
    }
}
