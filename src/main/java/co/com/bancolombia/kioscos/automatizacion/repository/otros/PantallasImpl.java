package co.com.bancolombia.kioscos.automatizacion.repository.otros;

import co.com.bancolombia.kioscos.automatizacion.modelos.BD.PantallaTextKio;
import co.com.bancolombia.kioscos.automatizacion.utils.ConnectionBaseDatos;

import java.sql.*;

public class PantallasImpl implements Repositorio<PantallaTextKio> {
    private Connection getConnection() throws SQLException {
        return ConnectionBaseDatos.getInstance();
    }

    @Override
    public Long insert(PantallaTextKio pantallaTextKio) {
        Long id = null;
        try (PreparedStatement stmtUpdate = getConnection().
                prepareStatement("INSERT INTO pantallas(text,tolerancia,id_flujo) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)){
            stmtUpdate.setString(1,pantallaTextKio.getText());
            stmtUpdate.setDouble(2,pantallaTextKio.getTolerancia());
            stmtUpdate.setLong(3,pantallaTextKio.getId_flujo());
            stmtUpdate.executeUpdate();
            try (ResultSet generatedKeys = stmtUpdate.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
