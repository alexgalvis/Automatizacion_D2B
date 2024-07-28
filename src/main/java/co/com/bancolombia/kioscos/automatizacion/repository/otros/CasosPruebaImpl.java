package co.com.bancolombia.kioscos.automatizacion.repository.otros;

import co.com.bancolombia.kioscos.automatizacion.modelos.BD.CasoPruebaKio;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CasosPruebaImpl implements Repositorio<CasoPruebaKio>{

    private Connection getConnection() throws SQLException {
        return ConnectionBaseDatos.getInstance();
    }

    @Override
    public ArrayList<CasoPruebaKio> listarPorCategoria(Long idFlujo) {
        return null;
    }

    @Override
    public CasoPruebaKio porId(Long id) {
        return null;
    }

    @Override
    public Long insert(CasoPruebaKio casoPruebaKio) {
        return null;
    }
}
